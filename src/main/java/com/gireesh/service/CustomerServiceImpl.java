package com.gireesh.service;

import com.gireesh.dao.CustomerDao;
import com.gireesh.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl {
    @Value("${success.code}")
    private String successCode;
    @Value("${success.message}")
    private String successMessage;

    @Autowired
    CustomerDao customerDao;


    public void insertCustomer(Customer customer) {
        customerDao.save(customer);
    }


    public List<String> getCustomerNames() {
        return null;
    }

//    public List<Product> getAllCustomers() {
//        List<Product> productList = jdbcTemplate.queryForList(SELECT_ALL_PRODUCTS, (rs,rownum)->{
//            Product.bui
//        });
//        return productList;
//    }

    public Customer getCustomerById(String customerId) {
        return  null;

    }

    public Customer getCustomerByName(String customerId) {
        return  null;

    }

    public List<Customer> getAllCustomers() {

        return null;
    }
}
