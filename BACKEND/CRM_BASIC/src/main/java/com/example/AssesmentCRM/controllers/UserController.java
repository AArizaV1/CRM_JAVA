package com.example.AssesmentCRM.controllers;


import com.example.AssesmentCRM.models.UserEntity;
import com.example.AssesmentCRM.services.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Properties;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    /*
    VARIABLES
    */
    @Autowired
    private UserService userService;

    /*
    GET ALL USERS METHOD
    */
    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    /*
    CREATE USER METHOD
    */
    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        return userService.createUser(userEntity);
    }

    /*
    GET USER BY ID METHOD
    */
    @GetMapping("{id_user}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable long id_user) {
        return userService.getUserById(id_user);
    }

    /*
    UPDATE USER BY ID METHOD
    */
    @PutMapping("{id_user}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable long id_user, @RequestBody UserEntity userEntity) {
        return userService.updateUser(id_user, userEntity);
    }

    /*
    DELETE USER BY ID METHOD
    */
    @DeleteMapping("{id_user}")
    public ResponseEntity<UserEntity> deleteUser(@PathVariable long id_user) {
        return userService.deleteUser(id_user);
    }

    /*
    LOGIN USER METHOD
    */
    /* DOESN'T WORK -

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody String credentials){

        final Gson gson = new Gson();
        final Properties prop = gson.fromJson(credentials, Properties.class);

        String email = prop.getProperty("email");
        String pass = prop.getProperty("password");

        return userService.login(email, pass);
    }
    */
}