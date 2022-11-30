package com.castelli.finaspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.castelli.finaspring.model.Fina;

@Repository
public interface FinaRepository extends JpaRepository<Fina, Long>{
    
}
