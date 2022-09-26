package com.example.case_study.service;

import com.example.case_study.model.Customer;
import com.example.case_study.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {

    Page<Employee> findByName(String name, String phone, String idCard, Pageable pageable);

    Employee findById(int id);

    void save(Employee employee);

    void update(Employee employee);

    void remove(int id);
}
