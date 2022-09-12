package customer.service;

import customer.model.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();

    Customer findOne(Long id);
}
