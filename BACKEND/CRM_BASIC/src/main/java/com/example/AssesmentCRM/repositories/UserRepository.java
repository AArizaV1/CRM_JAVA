package com.example.AssesmentCRM.repositories;

import com.example.AssesmentCRM.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

/*
    @Query(value = "SELECT s FROM user s WHERE email LIKE :email")
    UserEntity findByEmail(String email);
*/
}
