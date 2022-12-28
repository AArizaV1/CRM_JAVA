package com.example.AssesmentCRM.controllers;

import com.example.AssesmentCRM.models.ContactEntity;
import com.example.AssesmentCRM.models.UserEntity;
import com.example.AssesmentCRM.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/contact")
public class ContactController {

    /*
    VARIABLES
    */
    @Autowired
    private ContactService contactService;

    /*
    GET ALL CONTACTS METHOD
    */
    @GetMapping
    public List<ContactEntity> getAllContacts() {
        return contactService.getAllContacts();
    }

    /*
    GET CONTACT BY ID
    */
    @GetMapping("{id_contact}")
    public ResponseEntity<ContactEntity> getContactById(@PathVariable long id_contact) {
        return contactService.getContactById(id_contact);
    }

    /*
    CREATE CONTACT METHOD
    */
    @PostMapping
    public ContactEntity createContact(@RequestBody ContactEntity contactEntity) {
        return contactService.createContact(contactEntity);
    }

}
