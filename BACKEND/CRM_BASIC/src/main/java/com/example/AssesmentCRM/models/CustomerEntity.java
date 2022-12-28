package com.example.AssesmentCRM.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    /*
    VARIABLES
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private long idCustomer;
    @Column(name = "customer_name", length = 45)
    private String customerName;
    @Column(name = "customer_phone", length = 45)
    private String customerPhone;
    @Column(name = "customer_email", length = 45)
    private String customerEmail;

    @OneToMany(mappedBy = "customer_entity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OpportunityEntity> opportunities;

    /*
    CONSTRUCTOR
    */
        /*
        NO ARGUMENTS
        */
    public CustomerEntity() {
    }

    /*
    FULL ARGUMENTS
    */
    public CustomerEntity(long idCustomer, String customerName, String customerPhone, String customerEmail, List<OpportunityEntity> opportunities) {
        this.idCustomer = idCustomer;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.opportunities = opportunities;
    }

    /*
    GETTERS AND SETTERS
    */
    public long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public List<OpportunityEntity> getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(List<OpportunityEntity> opportunities) {
        this.opportunities = opportunities;
    }


    /*
    TO STRING
    */
    @Override
    public String toString() {
        return "CustomerEntity{" + "idCustomer=" + idCustomer + ", customerName='" + customerName + '\'' + ", customerPhone='" + customerPhone + '\'' + ", customerEmail='" + customerEmail + '\'' + ", opportunities=" + opportunities + '}';
    }
}