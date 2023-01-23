package com.castelli.finaspring.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.castelli.finaspring.auth.model.AuthUser;

public interface UserRepository extends JpaRepository<AuthUser, String> {
    
}
