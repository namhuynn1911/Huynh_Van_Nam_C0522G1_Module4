package com.example.case_study.repository;

import com.example.case_study.model.Customer;
import com.example.case_study.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select * from employee where employee_name like %:keyword1% and phone like %:keyword2% and id_card like %:keyword3%", nativeQuery = true)
    Page<Employee> searchByName(@Param("keyword1") String name, @Param("keyword2") String phone, @Param("keyword3") String idCard, Pageable pageable);

    Employee findById(int id);
}