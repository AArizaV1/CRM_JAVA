package com.example.AssesmentCRM.contact;

import com.example.AssesmentCRM.models.ContactEntity;
import com.example.AssesmentCRM.services.ContactService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactServiceTest {

    /*
    VARIABLES
    */
    @Autowired
    private ContactService contactService;

    ContactEntity contact1;

    /*
    SETTERS OF ENTITY
    */
    @Before
    public void setUp() {
        contact1 = new ContactEntity();
        contact1.setContactDate(LocalDateTime.of(2022, 05, 16, 17, 30));
        contact1.setContactDescription("Web relacionada en Ecommerce con urgencias.");
        contact1.setOpportunity_entity(contact1.getOpportunity_entity());

        contact1.setIdContact(2);

    }

    /*
    TEST CREATE CONTACT
    */
    @Test
    public void createContact() {
        Integer numberContact = this.contactService.getAllContacts().size();
        this.contactService.createContact(contact1);
        Assert.assertEquals(this.contactService.getAllContacts().size(), numberContact + 1);
    }

    /*
    TEST DELETE CONTACT
    */
    @Test
    public void deleteContact() {
        Integer numberContact = this.contactService.getAllContacts().size();
        this.contactService.deleteContact(contact1.getIdContact());
        Assert.assertEquals(this.contactService.getAllContacts().size(), numberContact - 1);
    }
}