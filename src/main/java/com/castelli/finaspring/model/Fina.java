package com.castelli.finaspring.model;


import java.time.LocalDate;


//import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Fina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @Column(length = 10, nullable = false)
    private Double credit;

    @Column(length = 200, nullable = false)
    private String description;

    @Column(length = 30, nullable = false)
    private String category;

    @Column(length = 200, nullable = false)
    private String tokenAuthenticatedUser;


    
    //@DateTimeFormat(pattern = "yyyy-MM")
    @JsonFormat(pattern="yyyy-MM")
    @JsonProperty("_date")
    private LocalDate date = LocalDate.now();


    
}
