package com.product_new.repository;

import com.product_new.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll();

    void save(Product product);
//
//    Product findById(int id);
//
//
//    void update(Product product);
//
//    void remove(int id);
//
//    List<Product>finByName(String name);
}
