package com.castelli.finaspring.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.castelli.finaspring.auth.model.User;

public interface UserRepository extends JpaRepository<User, String> {
    
}
