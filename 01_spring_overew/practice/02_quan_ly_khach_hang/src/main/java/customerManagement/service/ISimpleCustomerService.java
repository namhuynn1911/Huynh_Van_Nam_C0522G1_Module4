package customerManagement.service;

import customerManagement.model.Customer;

import java.util.List;

public interface ISimpleCustomerService {

    List<Customer> findAll();

    Customer findOne(Long id);



}
