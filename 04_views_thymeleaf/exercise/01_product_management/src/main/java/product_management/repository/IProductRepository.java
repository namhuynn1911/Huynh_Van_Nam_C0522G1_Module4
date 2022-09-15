package product_management.repository;

import product_management.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll();

    void save(Product product);

    void remove(int id);

    Product findById(int id);

    void update(Product product);

    List<Product>finByName(String name);
}
