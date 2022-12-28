package com.example.AssesmentCRM.controllers;

import com.example.AssesmentCRM.models.OpportunityEntity;
import com.example.AssesmentCRM.models.UserEntity;
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
    public List<OpportunityEntity> getAllOpportunities() {
        return opportunityService.getAllOpportunities();
    }

    /*
    GET OPPORTUNITY BY ID METHOD
    */
    @GetMapping("{id_opportunity}")
    public ResponseEntity<OpportunityEntity> getOpportunityById(@PathVariable long id_opportunity) {
        return opportunityService.getOpportunityById(id_opportunity);
    }

    /*
    UPDATE OPPORTUNITY BY ID METHOD
    */
    @PutMapping("{id_opportunity}")
    public ResponseEntity<OpportunityEntity> updateOpportunity(@PathVariable long id_opportunity, @RequestBody OpportunityEntity opportunityEntity) {
        return opportunityService.updateOpportunity(id_opportunity, opportunityEntity);
    }

    /*
    HIDE OPPORTUNITY BY ID METHOD
    */

    @PutMapping(name = "{id_opportunity}")
    public OpportunityEntity hideOpportunity(@PathVariable long id_opportunity) {
        return opportunityService.hideOpportunity(id_opportunity);
    }


    /*
    CREATE OPPORTUNITY METHOD
    */
    @PostMapping
    public OpportunityEntity createOpportunity(@RequestBody OpportunityEntity opportunityEntity) {
        return opportunityService.createOpportunity(opportunityEntity);
    }


}
