package product_management.repository.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import product_management.model.Product;
import product_management.repository.IProductRepository;


import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {


    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("SELECT p FROM Product AS p").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    @Override
    public void save(Product product) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    @Override
    public void remove(int id) {
        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery("SELECT p FROM Product AS p WHERE p.id = :id", Product.class);
        query.setParameter("id", id);
        Product product = query.getSingleResult();

        Transaction transaction = null;
        Session session = null;


        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.remove(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }


    @Override
    public Product findById(int id) {
        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery("select p from Product as p where p.id = : id", Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void update(Product product) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Product> finByName(String name) {
        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery("select p from Product as p where p.name like :name", Product.class);
        query.setParameter("name","%"+ name+"%");
        return query.getResultList();
    }
}


//    @Override
//    public Product findById(int id) {
//        return productMap.get(id);
//    }
//
//    @Override
//    public void update(Product product) {
//        productMap.put(product.getId(), product);
//    }
//
//    @Override
//    public void remove(int id) {
//        productMap.remove(id);
//    }
//
//    @Override
//    public List<Product> finByName(String name) {
//        List<Product> productList = new ArrayList<>();
//        for (Map.Entry<Integer, Product> productEntry : productMap.entrySet()) {
//            if (productEntry.getValue().getName().contains(name)) {
//                productList.add(productEntry.getValue());
//            }
//        }
//        return productList;
//    }

