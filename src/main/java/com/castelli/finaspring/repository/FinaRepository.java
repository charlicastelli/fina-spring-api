package com.castelli.finaspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.castelli.finaspring.model.Fina;

public interface FinaRepository extends JpaRepository<Fina, Long>{
    
}
