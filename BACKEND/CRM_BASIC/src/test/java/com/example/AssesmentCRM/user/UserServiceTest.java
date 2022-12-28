package com.example.AssesmentCRM.user;

import com.example.AssesmentCRM.models.UserEntity;
import com.example.AssesmentCRM.repositories.UserRepository;
import com.example.AssesmentCRM.services.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    /*
    VARIABLES
    */
    @Autowired
    private UserService userService;
    private UserRepository userRepository;
    UserEntity user1;

    /*
    SETTERS OF ENTITY
    */
    @Before
    public void setUp() {
        user1 = new UserEntity();
        user1.setUsername("Prueba");
        user1.setPassword("PruebaPass123!");
        user1.setEmail("prueba@solera.com");
    }


    /*
    TEST CREATE USER
    */
    @Test
    public void createUser() {
        Integer numberUser = this.userService.getAllUsers().size();
        this.userService.createUser(user1);
        Assert.assertEquals(this.userService.getAllUsers().size(), numberUser + 1);
    }

    /*
    TEST UPDATE USER
    */
    @Test
    public void updateUser() {
        user1.setIdUser(2);
        user1.setUsername("TestUpdate");
        user1.setPassword("Update123!");
        user1.setEmail("test@update.com");

        this.userService.updateUser(user1.getIdUser(), user1);

        ResponseEntity<UserEntity> userResponse = userService.getUserById(user1.getIdUser());

        Assert.assertEquals("TestUpdate", userResponse.getBody().getUsername());
        Assert.assertEquals("Update123!", userResponse.getBody().getPassword());
        Assert.assertEquals("test@update.com", userResponse.getBody().getEmail());

    }

}
