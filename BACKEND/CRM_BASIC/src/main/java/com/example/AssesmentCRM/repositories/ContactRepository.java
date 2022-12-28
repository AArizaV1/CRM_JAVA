package com.example.AssesmentCRM.repositories;

import com.example.AssesmentCRM.models.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called ContactRepository
// CRUD refers Create, Read, Update, Delete

public interface ContactRepository extends JpaRepository<ContactEntity, Long> {


}
