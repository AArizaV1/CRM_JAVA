package com.example.AssesmentCRM.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class ContactEntityDTO {

    /*
    VARIABLES
    */
    private long idContact;
    private LocalDateTime contactDate;
    private String contactDescription;
    private Long idOpportunity;



    /*
    CONSTRUCTOR
    */
        /*
        NO ARGUMENTS
        */
        public ContactEntityDTO() {
        }

        /*
        ALL ARGUMENTS
        */
        public ContactEntityDTO(long idContact, LocalDateTime contactDate, String contactDescription,
                Long idOpportunity) {
            this.idContact = idContact;
            this.contactDate = contactDate;
            this.contactDescription = contactDescription;
            this.idOpportunity = idOpportunity;
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

    public Long getIdOpportunity() {
        return idOpportunity;
    }

    public void setIdOpportunity(Long idOpportunity) {
        this.idOpportunity = idOpportunity;
    }
/*
    TO STRING
    */

    @Override
    public String toString() {
        return "ContactEntityDTO{" +
                "idContact=" + idContact +
                ", contactDate=" + contactDate +
                ", contactDescription='" + contactDescription + '\'' +
                ", idOpportunity=" + idOpportunity +
                '}';
    }
}
