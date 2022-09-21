package com.example.case_study.repository;

import com.example.case_study.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findById(int id);

    @Query(value = "select * from customer where customer_name like %:keyword% ",nativeQuery = true)
    Page<Customer> searchByName(@Param("keyword") String name, Pageable pageable);
}
