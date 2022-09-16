package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    Product findById(int id);

    @Query(value = "select * from Product where name like %:keywork%",nativeQuery = true)
    List<Product> searchByName(@Param("keywork") String name);
//    void remove(int id);
//
//    void update(Product product);
}
