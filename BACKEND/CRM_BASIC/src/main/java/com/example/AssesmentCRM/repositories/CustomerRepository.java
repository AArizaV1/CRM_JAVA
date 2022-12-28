package com.example.AssesmentCRM.repositories;

import com.example.AssesmentCRM.models.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called CustomerRepository
// CRUD refers Create, Read, Update, Delete

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {


}
