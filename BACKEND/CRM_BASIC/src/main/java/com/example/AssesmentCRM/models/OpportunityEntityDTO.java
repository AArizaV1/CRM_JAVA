package com.example.AssesmentCRM.models;
import java.util.List;

public class OpportunityEntityDTO {

    private long idOpportunity;
    private String opportunityName;
    private String opportunityPhone;
    private String opportunityEmail;
    private Long idCustomer;


    public OpportunityEntityDTO(long idOpportunity, String opportunityName, String opportunityPhone,
            String opportunityEmail, Long idCustomer) {
        this.idOpportunity = idOpportunity;
        this.opportunityName = opportunityName;
        this.opportunityPhone = opportunityPhone;
        this.opportunityEmail = opportunityEmail;
        this.idCustomer = idCustomer;
    }

    public OpportunityEntityDTO(long idOpportunity, String opportunityName, String opportunityPhone,
            String opportunityEmail) {
        this.idOpportunity = idOpportunity;
        this.opportunityName = opportunityName;
        this.opportunityPhone = opportunityPhone;
        this.opportunityEmail = opportunityEmail;
    }

    public OpportunityEntityDTO() {

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

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public String toString() {
        return "OpportunityEntityDTO{" +
                "idOpportunity=" + idOpportunity +
                ", opportunityName='" + opportunityName + '\'' +
                ", opportunityPhone='" + opportunityPhone + '\'' +
                ", opportunityEmail='" + opportunityEmail + '\'' +
                ", idCustomer=" + idCustomer +
                '}';
    }
}
