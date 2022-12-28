package com.example.AssesmentCRM.customer;

import com.example.AssesmentCRM.models.CustomerEntity;
import com.example.AssesmentCRM.services.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    /*
    VARIABLES
    */
    @Autowired
    private CustomerService customerService;


    CustomerEntity customer1;

    /*
    SETTERS OF ENTITY
    */
    @Before
    public void setUp() {
        customer1 = new CustomerEntity();
        customer1.setCustomerName("Roberto");
        customer1.setCustomerPhone("+351 576 34 456");
        customer1.setCustomerEmail("roberto@solera.com");
        customer1.setOpportunities(customer1.getOpportunities());
    }

    /*
    TEST CREATE CUSTOMER
    */
    @Test
    public void createCustomer() {
        Integer numberCustomer = this.customerService.getAllCustomers().size();
        this.customerService.createCustomer(customer1);
        Assert.assertEquals(this.customerService.getAllCustomers().size(), numberCustomer + 1);
    }

    /*
    TEST UPDATE OPPORTUNITY
    */
    @Test
    public void updateCustomer() {
        customer1.setIdCustomer(1);
        customer1.setCustomerName("TestCustomer");
        customer1.setCustomerPhone("+351 657 46 475");
        customer1.setCustomerEmail("customer@updateTest.com");


        this.customerService.updateCustomer(customer1.getIdCustomer(), customer1);

        ResponseEntity<CustomerEntity> customerResponse = customerService.getCustomerById(customer1.getIdCustomer());

        Assert.assertEquals("TestCustomer", customerResponse.getBody().getCustomerName());
        Assert.assertEquals("+351 657 46 475", customerResponse.getBody().getCustomerPhone());
        Assert.assertEquals("customer@updateTest.com", customerResponse.getBody().getCustomerEmail());
    }
}
