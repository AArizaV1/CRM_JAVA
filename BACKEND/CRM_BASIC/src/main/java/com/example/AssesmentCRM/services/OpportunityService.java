package com.example.AssesmentCRM.services;

import com.example.AssesmentCRM.exception.ResourceNotFoundException;
import com.example.AssesmentCRM.models.CustomerEntity;
import com.example.AssesmentCRM.models.OpportunityEntity;
import com.example.AssesmentCRM.models.OpportunityEntityDTO;
import com.example.AssesmentCRM.repositories.CustomerRepository;
import com.example.AssesmentCRM.repositories.OpportunityRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpportunityService {

    /*
    VARIABLES
    */
    @Autowired
    public OpportunityRepository opportunityRepository;
    @Autowired
    public CustomerRepository customerRepository;

    /*
    GET ALL OPPORTUNITIES METHOD
    */
    public List<OpportunityEntityDTO> getAllOpportunities() {
        List<OpportunityEntityDTO> response = new ArrayList<>();

        for (OpportunityEntity o : opportunityRepository.findAll()){
            if(o.getCustomer_entity()!=null)
           response.add(new OpportunityEntityDTO(o.getIdOpportunity(), o.getOpportunityName(), o.getOpportunityPhone(),o.getOpportunityEmail(),o.getCustomer_entity().getIdCustomer()));
            else response.add(new OpportunityEntityDTO(o.getIdOpportunity(), o.getOpportunityName(), o.getOpportunityPhone(),o.getOpportunityEmail(),
                    null));
        }
        return response;
    }

    /*
    GET OPPORTUNITY BY ID METHOD
    */

    public OpportunityEntityDTO getOpportunityById(long id_opportunity) {
        OpportunityEntity opportunityEntity = opportunityRepository.findById(id_opportunity)
                .orElseThrow(() -> new ResourceNotFoundException("Opportunity not exist with id: " + id_opportunity));

        if(opportunityEntity.getCustomer_entity()!=null) {
            return new OpportunityEntityDTO(opportunityEntity.getIdOpportunity(),
                    opportunityEntity.getOpportunityName(), opportunityEntity.getOpportunityPhone(),
                    opportunityEntity.getOpportunityEmail(), opportunityEntity.getCustomer_entity().getIdCustomer());
        }
        return new OpportunityEntityDTO(opportunityEntity.getIdOpportunity(),
                opportunityEntity.getOpportunityName(), opportunityEntity.getOpportunityPhone(),
                opportunityEntity.getOpportunityEmail(),
                null);
    }



    /*
    CREATE OPPORTUNITY METHOD
    */
    public OpportunityEntity createOpportunity(OpportunityEntityDTO opportunityEntityDTO) {
        Optional<CustomerEntity> opportunityFromDb;
        if (opportunityEntityDTO.getIdCustomer() != null) {
            opportunityFromDb = customerRepository.findById(opportunityEntityDTO.getIdCustomer());
            if (opportunityFromDb.isPresent()) {
                OpportunityEntity opportunityEntity= new OpportunityEntity(opportunityEntityDTO.getIdOpportunity(), opportunityEntityDTO.getOpportunityName(), opportunityEntityDTO.getOpportunityPhone(), opportunityEntityDTO.getOpportunityEmail(), opportunityFromDb.get());
                return opportunityRepository.save(opportunityEntity);
            }
        }
        OpportunityEntity opportunityEntity= new OpportunityEntity(opportunityEntityDTO.getIdOpportunity(), opportunityEntityDTO.getOpportunityName(), opportunityEntityDTO.getOpportunityPhone(), opportunityEntityDTO.getOpportunityEmail());
        return opportunityRepository.save(opportunityEntity);
    }

     /*
     UPDATE OPPORTUNITY BY ID METHOD
     */

    public ResponseEntity<OpportunityEntityDTO> updateOpportunity(long id_opportunity, OpportunityEntityDTO opportunityEntityDTO) {

        System.out.println(opportunityEntityDTO.toString());

        OpportunityEntity updateOpportunity = opportunityRepository.findById(id_opportunity)
                .orElseThrow(() -> new ResourceNotFoundException("Opportunity not exist with id: " + id_opportunity));

        updateOpportunity.setOpportunityName(opportunityEntityDTO.getOpportunityName());
        updateOpportunity.setOpportunityPhone(opportunityEntityDTO.getOpportunityPhone());
        updateOpportunity.setOpportunityEmail(opportunityEntityDTO.getOpportunityEmail());
        updateOpportunity.setCustomer_entity(customerRepository.findById(opportunityEntityDTO.getIdCustomer()).get());
        

        opportunityRepository.save(updateOpportunity);

        return ResponseEntity.ok(opportunityEntityDTO);
    }

    /*
     DELETE OPPORTUNITY BY ID METHOD
     */
    public void deleteOpportunity(long id_opportunity) {
       opportunityRepository.deleteById(id_opportunity);
    }

}
