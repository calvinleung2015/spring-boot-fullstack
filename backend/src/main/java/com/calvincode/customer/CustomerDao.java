package com.calvincode.customer;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerDao {
    List<Customer> selectAllCustomers();
    Optional<Customer> selectCustomerById(Integer id);

    void insertCustomer(Customer customer);

    void deleteCustomerById(Integer id);

    void updateCustomer(Customer update);

    boolean existsPersonWithEmail(String email);

    boolean existsPersonWithId(Integer customerId);
}
