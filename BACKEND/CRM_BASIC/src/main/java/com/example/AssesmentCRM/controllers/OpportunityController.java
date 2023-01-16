package com.example.AssesmentCRM.controllers;

import com.example.AssesmentCRM.models.CustomerEntity;
import com.example.AssesmentCRM.models.OpportunityEntity;
import com.example.AssesmentCRM.models.OpportunityEntityDTO;
import com.example.AssesmentCRM.services.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/opportunity")
public class OpportunityController {

    /*
    VARIABLES
    */
    @Autowired
    private OpportunityService opportunityService;

    /*
    GET ALL OPPORTUNITIES METHOD
    */
    @GetMapping
    public List<OpportunityEntityDTO> getAllOpportunities() {
        return opportunityService.getAllOpportunities();
    }

    /*
    GET OPPORTUNITY BY ID METHOD
    */
    @GetMapping("/{id_opportunity}")
    public OpportunityEntityDTO getOpportunityById(@PathVariable long id_opportunity) {
        return opportunityService.getOpportunityById(id_opportunity);
    }

    /*
    UPDATE OPPORTUNITY BY ID METHOD
    */
    @PutMapping("/{id_opportunity}")
    public ResponseEntity<OpportunityEntityDTO> updateOpportunity(@PathVariable long id_opportunity, @RequestBody OpportunityEntityDTO opportunityEntityDTO) {
        return opportunityService.updateOpportunity(id_opportunity, opportunityEntityDTO);
    }

    /*
    DELETE OPPORTUNITY BY ID METHOD
    */

    @DeleteMapping("/{id_opportunity}")
    public void deleteOpportunity(@PathVariable long id_opportunity) {
        opportunityService.deleteOpportunity(id_opportunity);
    }


    /*
    CREATE CUSTOMER METHOD
    */
    @PostMapping
    public OpportunityEntity createOpportunity(@RequestBody OpportunityEntityDTO opportunityEntityDTO) {
        return opportunityService.createOpportunity(opportunityEntityDTO);
    }

}
