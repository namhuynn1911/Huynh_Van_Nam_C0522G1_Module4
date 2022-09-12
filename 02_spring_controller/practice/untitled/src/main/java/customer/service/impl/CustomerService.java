package customer.service.impl;

import customer.model.Customer;
import customer.service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {

    private static List<Customer> customers;
    private static long autoIncreaseId = 0;

    static {
        customers.add(new Customer(autoIncreaseId++, "T", "t@codegym.vn", "Da Nang"));
        customers.add(new Customer(autoIncreaseId++, "Nhat", "nhat@codegym.vn", "Quang Tri"));
        customers.add(new Customer(autoIncreaseId++, "Trang", "trang@codegym.vn", "Ha Noi"));
        customers.add(new Customer(autoIncreaseId++, "Nguyen Binh Son", "son@codegym.vn", "Sai Gon"));
        customers.add(new Customer(autoIncreaseId++, "Dang Xuan Hoa", "hoa.dang@codegym.vn", "Da Nang"));
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer findOne(Long id) {
        return null;
    }
}
