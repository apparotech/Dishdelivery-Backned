package com.socialmore.dishdelivery.entity;

import java.util.Set;

import com.socialmore.dishdelivery.enuk.Role;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userId;


    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    @ElementCollection(fetch= FetchType.EAGER)
    @Enumerated(EnumType.STRING)

    private Set<Role> roles;

}
