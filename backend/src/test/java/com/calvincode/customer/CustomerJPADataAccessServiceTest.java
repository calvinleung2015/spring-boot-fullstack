package com.calvincode.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class CustomerJPADataAccessServiceTest {

    private CustomerJPADataAccessService underTest;
    @Mock
    private CustomerRepository customerRepository;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CustomerJPADataAccessService(customerRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void selectAllCustomers() {
        // When
        underTest.selectAllCustomers();

        // Then
        verify(customerRepository)
                .findAll();
    }

    @Test
    void selectCustomerById() {
        // Given
        int id = 1;

        // When
        underTest.selectCustomerById(id);

        // Then
        verify(customerRepository).findById(id);
    }

    @Test
    void insertCustomer() {
        // Given
        String email = "calvin@gmail.com";
        Customer newCustomer = new Customer(
                null,
                "calvin",
                email,
                25,
                Gender.MALE);

        // When
        underTest.insertCustomer(newCustomer);

        // Then
        verify(customerRepository).save(newCustomer);
    }

    @Test
    void deleteCustomerById() {

        // When
        underTest.deleteCustomerById(1);

        // Then
        verify(customerRepository).deleteById(1);
    }

    @Test
    void updateCustomer() {
        // Given
        String email = "calvin@gmail.com";
        Customer newCustomer = new Customer(
                1,
                "calvin",
                email,
                25,
                Gender.MALE);

        underTest.updateCustomer(newCustomer);

        // Then
        verify(customerRepository).save(newCustomer);
    }

    @Test
    void existsPersonWithEmail() {
        // Given
        String email = "calvin@gmail.com";

        // When
        underTest.existsPersonWithEmail(email);

        // Then
        verify(customerRepository).existsCustomerByEmail(email);
    }

    @Test
    void existsPersonWithId() {
        // Given
        int id = 1;

        // When
        underTest.existsPersonWithId(id);

        // Then
        verify(customerRepository).existsCustomerById(id);
    }
}