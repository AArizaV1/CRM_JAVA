package com.example.AssesmentCRM.services;

import com.example.AssesmentCRM.exception.ResourceNotFoundException;
import com.example.AssesmentCRM.models.CustomerEntity;
import com.example.AssesmentCRM.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    /*
    VARIABLES
    */
    @Autowired
    public CustomerRepository customerRepository;


    /*
    GET ALL CUSTOMERS METHOD
    */
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }


    /*
    GET CUSTOMER BY ID METHOD
    */
    public ResponseEntity<CustomerEntity> getCustomerById(long id_customer) {
        CustomerEntity customerEntity = customerRepository.findById(id_customer).orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id: " + id_customer));
        return ResponseEntity.ok(customerEntity);
    }

    /*
    CREATE CUSTOMER METHOD
    */
    public CustomerEntity createCustomer(CustomerEntity customerEntity) {
        return customerRepository.save(customerEntity);
    }

    /*
     UPDATE CUSTOMER BY ID METHOD
     */
    public ResponseEntity<CustomerEntity> updateCustomer(long id_customer, CustomerEntity customerEntity) {

        CustomerEntity updateCustomer = customerRepository.findById(id_customer).orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id: " + id_customer));

        updateCustomer.setCustomerName(customerEntity.getCustomerName());
        updateCustomer.setCustomerPhone(customerEntity.getCustomerPhone());
        updateCustomer.setCustomerEmail(customerEntity.getCustomerEmail());

        customerRepository.save(updateCustomer);

        return ResponseEntity.ok(updateCustomer);
    }

    /*
     DELETE OPPORTUNITY BY ID METHOD
    */
    public void deleteCustomer(long id_customer) {
        customerRepository.deleteById(id_customer);
    }

}
