package com.example.AssesmentCRM.controllers;

import com.example.AssesmentCRM.models.ContactEntity;
import com.example.AssesmentCRM.models.ContactEntityDTO;
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
    GET CONTACT BY ID METHOD
    */
    @GetMapping("/id/{id_contact}")
    public ContactEntityDTO getContactById(@PathVariable long id_contact) {
        return contactService.getContactById(id_contact);
    }

    /*
    GET CONTACT BY ID OPPORTUNITY
    */
    @GetMapping("/{id_opportunity}")
    public List<ContactEntity> getContactByOpportunities(@PathVariable long id_opportunity) {
        return contactService.getContactsByOpportunities(id_opportunity);
    }


    /*
    CREATE CONTACT METHOD BY ID OPPORTUNITY
    */
    @PostMapping("/{id_opportunity}")
    public ContactEntity createContact(@PathVariable long id_opportunity, @RequestBody ContactEntity contactEntity) {
        return contactService.createContact(id_opportunity, contactEntity);
    }

    /*
    UPDATE OPPORTUNITY BY ID METHOD
    */
    @PutMapping("/{id_contact}")
    public ResponseEntity<ContactEntityDTO> updateContact(@PathVariable long id_contact, @RequestBody ContactEntityDTO contactEntityDTO) {
        return contactService.updateContact(id_contact, contactEntityDTO);
    }


    /*
    DELETE OPPORTUNITY BY ID METHOD
    */

    @DeleteMapping("/{id_contact}")
    public void deleteContact(@PathVariable long id_contact) {
        contactService.deleteContact(id_contact);
    }

}
