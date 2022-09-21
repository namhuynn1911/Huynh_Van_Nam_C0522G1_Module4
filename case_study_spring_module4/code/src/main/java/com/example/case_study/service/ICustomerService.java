package com.example.case_study.service;

import com.example.case_study.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {

    Page<Customer> findByName(String name, Pageable pageable);

    Customer findById(int id);

    void save(Customer customer);
}
