package com.example.AssesmentCRM.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contact")
public class ContactEntity {

    /*
    VARIABLES
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact")
    private long idContact;
    @Column(name = "contact_date")
    private LocalDateTime contactDate;
    @Column(name = "contact_description", length = 200)
    private String contactDescription;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "contact_id_opportunity")
    private OpportunityEntity opportunity_entity;


    /*
    CONSTRUCTOR
    */
    /*
    NO ARGUMENTS
    */
    public ContactEntity() {
    }

    /*
    ALL ARGUMENTS
    */
    public ContactEntity(long idContact, LocalDateTime contactDate, String contactDescription, OpportunityEntity opportunity_entity) {
        this.idContact = idContact;
        this.contactDate = contactDate;
        this.contactDescription = contactDescription;
        this.opportunity_entity = opportunity_entity;
    }

    /*
    GETTERS AND SETTERS
    */
    public long getIdContact() {
        return idContact;
    }

    public void setIdContact(long idContact) {
        this.idContact = idContact;
    }

    public LocalDateTime getContactDate() {
        return contactDate;
    }

    public void setContactDate(LocalDateTime contactDate) {
        this.contactDate = contactDate;
    }

    public String getContactDescription() {
        return contactDescription;
    }

    public void setContactDescription(String contactDescription) {
        this.contactDescription = contactDescription;
    }

    public OpportunityEntity getOpportunity_entity() {
        return opportunity_entity;
    }

    public void setOpportunity_entity(OpportunityEntity opportunity_entity) {
        this.opportunity_entity = opportunity_entity;
    }

    /*
    TO STRING
    */
    @Override
    public String toString() {
        return "ContactEntity{" + "idContact=" + idContact + ", contactDate=" + contactDate + ", contactDescription='" + contactDescription + '\'' + ", opportunity_entity=" + opportunity_entity + '}';
    }
}
