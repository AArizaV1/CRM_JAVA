package com.example.AssesmentCRM.repositories;

import com.example.AssesmentCRM.models.OpportunityEntity;
import org.springframework.data.jpa.repository.JpaRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called OpportunityRepository
// CRUD refers Create, Read, Update, Delete

public interface OpportunityRepository extends JpaRepository<OpportunityEntity, Long> {


}
