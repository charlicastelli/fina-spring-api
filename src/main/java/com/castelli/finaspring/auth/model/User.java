package com.castelli.finaspring.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(length = 100)
    private String username;
    private String name;
    private String password;
    private String role;
    private String token;
}
