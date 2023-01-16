package com.example.AssesmentCRM.services;

import com.example.AssesmentCRM.exception.ResourceNotFoundException;
import com.example.AssesmentCRM.models.ContactEntity;
import com.example.AssesmentCRM.models.ContactEntityDTO;
import com.example.AssesmentCRM.models.CustomerEntity;
import com.example.AssesmentCRM.models.OpportunityEntity;
import com.example.AssesmentCRM.models.OpportunityEntityDTO;
import com.example.AssesmentCRM.repositories.ContactRepository;
import com.example.AssesmentCRM.repositories.OpportunityRepository;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    /*
    VARIABLES
    */
    @Autowired
    public ContactRepository contactRepository;

    @Autowired
    public OpportunityRepository opportunityRepository;

    /*
    GET ALL CONTACTS METHOD
    */
    public List<ContactEntity> getAllContacts() {
        return contactRepository.findAll();
    }


    /*
    GET CONTACT BY ID OPPORTUNITY
    */
    public List<ContactEntity> getContactsByOpportunities(long id_opportunity) {
        return contactRepository.findAll().stream().filter(contact -> contact.getOpportunity_entity().getIdOpportunity() == id_opportunity).collect(
                Collectors.toList());
    }

    /*
    GET CONTACT BY ID CONTACT
    */
    public ResponseEntity<ContactEntity> getContactByIdV2(long id_contact) {
        ContactEntity contactEntity = contactRepository.findById(id_contact).orElseThrow(() -> new ResourceNotFoundException("Contact not exist with id: " + id_contact));
        return ResponseEntity.ok(contactEntity);
    }


    public ContactEntityDTO getContactById(long id_contact) {
        ContactEntity contactEntity = contactRepository.findById(id_contact)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not exist with id: " + id_contact));

        if(contactEntity.getOpportunity_entity()!=null) {
            return new ContactEntityDTO(contactEntity.getIdContact(),
                    contactEntity.getContactDate(), contactEntity.getContactDescription(),
                    contactEntity.getOpportunity_entity().getIdOpportunity());
        }
        return new ContactEntityDTO(contactEntity.getIdContact(),
                contactEntity.getContactDate(), contactEntity.getContactDescription(),
                null);
    }
















    /*
    CREATE CONTACT METHOD
    */
    public ContactEntity createContact(long id_opportunity, ContactEntity contactEntity) {

        OpportunityEntity opportunity = opportunityRepository.findById(id_opportunity).get();

        contactEntity.setOpportunity_entity(opportunity);


        return contactRepository.save(contactEntity);
    }


    /*
     UPDATE CUSTOMER BY ID METHOD
     */
    public ResponseEntity<ContactEntityDTO> updateContact(long id_contact, ContactEntityDTO contactEntityDTO) {

        System.out.println(contactEntityDTO.toString());

        ContactEntity updateContact = contactRepository.findById(id_contact)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not exist with id: " + id_contact));

        updateContact.setContactDate(contactEntityDTO.getContactDate());
        updateContact.setContactDescription(contactEntityDTO.getContactDescription());
        updateContact.setOpportunity_entity(opportunityRepository.findById(contactEntityDTO.getIdOpportunity()).get());

        contactRepository.save(updateContact);

        return ResponseEntity.ok(contactEntityDTO);
    }




    /*
    DELETE CONTACT BY ID METHOD
    */
    public void deleteContact(long id_contact) {
        contactRepository.deleteById(id_contact);
    }
}
