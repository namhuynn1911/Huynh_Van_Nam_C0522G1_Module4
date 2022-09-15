package com.product_new.repository.impl;

import com.product_new.model.Product;
import com.product_new.repository.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.product_new.repository.IProductRepository;

import java.util.List;


public class ProductRepository implements IProductRepository {


    @Override
    public List<Product> findAll() {
        Session session=null;
        List<Product> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product").getResultList();
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
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        } finally {
            if(session != null){
                session.close();
            }
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
}
