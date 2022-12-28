package com.example.AssesmentCRM.exception;

import com.example.AssesmentCRM.models.UserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    @GetMapping("{id_user}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable long id_user) {

        return null;
    }
}
