package com.example.AssesmentCRM.services;

import com.example.AssesmentCRM.exception.ResourceNotFoundException;
import com.example.AssesmentCRM.models.ContactEntity;
import com.example.AssesmentCRM.repositories.ContactRepository;
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

    /*
    GET ALL CONTACTS METHOD
    */
    public List<ContactEntity> getAllContacts() {
        return contactRepository.findAll();
    }


    /*
    GET CONTACT BY ID METHOD
    */
    public ResponseEntity<ContactEntity> getContactById(long id_contact) {
        ContactEntity contactEntity = contactRepository.findById(id_contact).orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + id_contact));
        return ResponseEntity.ok(contactEntity);
    }

    /*
    CREATE CONTACT METHOD
    */
    public ContactEntity createContact(ContactEntity contactEntity) {
        return contactRepository.save(contactEntity);
    }

    /*
    DELETE CONTACT BY ID METHOD
    */
    public ResponseEntity<ContactEntity> deleteContact(long id_contact) {
        ContactEntity deleteContact = contactRepository.findById(id_contact).orElseThrow(() -> new ResourceNotFoundException("Contact not exist with id: " + id_contact));
        contactRepository.delete(deleteContact);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
