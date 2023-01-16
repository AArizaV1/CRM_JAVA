package com.example.AssesmentCRM.controllers;

import com.example.AssesmentCRM.models.CustomerEntity;
import com.example.AssesmentCRM.models.OpportunityEntity;
import com.example.AssesmentCRM.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    /*
    VARIABLES
    */
    @Autowired
    private CustomerService customerService;

    /*
    GET ALL CUSTOMERS METHOD
    */
    @GetMapping
    public List<CustomerEntity> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    /*
    GET CUSTOMER BY ID METHOD
    */
    @GetMapping("/{id_customer}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable long id_customer) {
        return customerService.getCustomerById(id_customer);
    }

    /*
    UPDATE USER BY ID METHOD
    */
    @PutMapping("/{id_customer}")
    public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable long id_customer, @RequestBody CustomerEntity customerEntity) {
        return customerService.updateCustomer(id_customer, customerEntity);
    }

    /*
    CREATE CUSTOMER METHOD
    */
    @PostMapping
    public CustomerEntity createCustomer(@RequestBody CustomerEntity customerEntity) {
        return customerService.createCustomer(customerEntity);
    }

    /*
    DELETE CUSTOMER
    */
    @DeleteMapping("/{id_customer}")
    public void deleteCustomer(@PathVariable long id_customer) {
        customerService.deleteCustomer(id_customer);
    }


}
