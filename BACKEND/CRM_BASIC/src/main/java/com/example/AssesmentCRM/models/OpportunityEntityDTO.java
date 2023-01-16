package com.example.AssesmentCRM.models;
import java.util.List;

public class OpportunityEntityDTO {

    private long idOpportunity;
    private String opportunityName;
    private String opportunityPhone;
    private String opportunityEmail;
    private List<ContactEntity> contacts;
    private String customer_entity;

    public OpportunityEntityDTO(long idOpportunity, String opportunityName, String opportunityPhone,
            String opportunityEmail, List<ContactEntity> contacts,
            String customer_entity) {
        this.idOpportunity = idOpportunity;
        this.opportunityName = opportunityName;
        this.opportunityPhone = opportunityPhone;
        this.opportunityEmail = opportunityEmail;
        this.contacts = contacts;
        this.customer_entity = customer_entity;
    }

    public OpportunityEntityDTO(long idOpportunity, String opportunityName, String opportunityPhone,
            String opportunityEmail, List<ContactEntity> contacts) {
        this.idOpportunity = idOpportunity;
        this.opportunityName = opportunityName;
        this.opportunityPhone = opportunityPhone;
        this.opportunityEmail = opportunityEmail;
        this.contacts = contacts;
    }

    public OpportunityEntityDTO(String opportunityName, String opportunityPhone, String opportunityEmail,
            String customer_entity) {
        this.opportunityName = opportunityName;
        this.opportunityPhone = opportunityPhone;
        this.opportunityEmail = opportunityEmail;
        this.customer_entity = customer_entity;
    }

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

    public String getCustomer_entity() {
        return customer_entity;
    }

    public void setCustomer_entity(String customer_entity) {
        this.customer_entity = customer_entity;
    }
}
