package com.example.AssesmentCRM.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "opportunity")
public class OpportunityEntity {

    /*
    VARIABLES
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_opportunity")
    private long idOpportunity;
    @Column(name = "opportunity_name", length = 45)
    private String opportunityName;
    @Column(name = "opportunity_phone", length = 45)
    private String opportunityPhone;
    @Column(name = "opportunity_email", length = 45)
    private String opportunityEmail;


    @OneToMany(mappedBy = "opportunity_entity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContactEntity> contacts;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "opportunity_id_customer", nullable = true)
    private CustomerEntity customer_entity;


    /*
    CONSTRUCTOR
    */
        /*
        NO ARGUMENTS
        */
    public OpportunityEntity() {
    }

        /*
        ALL ARGUMENTS
        */

    public OpportunityEntity(long idOpportunity, String opportunityName, String opportunityPhone,
            String opportunityEmail, CustomerEntity customer_entity) {
        this.idOpportunity = idOpportunity;
        this.opportunityName = opportunityName;
        this.opportunityPhone = opportunityPhone;
        this.opportunityEmail = opportunityEmail;
        this.customer_entity = customer_entity;
    }

    public OpportunityEntity(long idOpportunity, String opportunityName, String opportunityPhone, String opportunityEmail, List<ContactEntity> contacts, CustomerEntity customer_entity) {
        this.idOpportunity = idOpportunity;
        this.opportunityName = opportunityName;
        this.opportunityPhone = opportunityPhone;
        this.opportunityEmail = opportunityEmail;
        this.contacts = contacts;
        this.customer_entity = customer_entity;
    }

    public OpportunityEntity(long idOpportunity, String opportunityName, String opportunityPhone, String opportunityEmail) {
        this.idOpportunity = idOpportunity;
        this.opportunityName = opportunityName;
        this.opportunityPhone = opportunityPhone;
        this.opportunityEmail = opportunityEmail;
    }

    public OpportunityEntity(String opportunityName, String opportunityPhone, String opportunityEmail, CustomerEntity customer_entity) {
        this.opportunityName = opportunityName;
        this.opportunityPhone = opportunityPhone;
        this.opportunityEmail = opportunityEmail;
        this.customer_entity = customer_entity;
    }

    public OpportunityEntity(long idOpportunity, String opportunityName, String opportunityPhone,
            String opportunityEmail, OpportunityEntity opportunityEntity) {

    }

    /*
                GETTERS AND SETTERS
                */
    public long getIdOpportunity() {
        return idOpportunity;
    }

    public void setIdOpportunity(long idOpportunity) {
        this.idOpportunity = idOpportunity;
    }

    public String getOpportunityName() {
        return opportunityName;
    }

    public void setOpportunityName(String opportunityName) {
        this.opportunityName = opportunityName;
    }

    public String getOpportunityPhone() {
        return opportunityPhone;
    }

    public void setOpportunityPhone(String opportunityPhone) {
        this.opportunityPhone = opportunityPhone;
    }

    public String getOpportunityEmail() {
        return opportunityEmail;
    }

    public void setOpportunityEmail(String opportunityEmail) {
        this.opportunityEmail = opportunityEmail;
    }

    public List<ContactEntity> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactEntity> contacts) {
        this.contacts = contacts;
    }

    public CustomerEntity getCustomer_entity() {
        return customer_entity;
    }

    public void setCustomer_entity(CustomerEntity customer_entity) {
        this.customer_entity = customer_entity;
    }

    /*
    TO STRING
    */
    @Override
    public String toString() {
        return "";
    }
}
