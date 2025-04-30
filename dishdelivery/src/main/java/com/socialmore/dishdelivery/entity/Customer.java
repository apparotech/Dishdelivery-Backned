package com.socialmore.dishdelivery.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data
//@ToString
@NoArgsConstructor
@AllArgsConstructor
//@DiscriminatorValue("CUSTOMER")
public class Customer {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Integer customerId;
    private String username;
    private String password;
    private  String email;
    private  String firstName;
    private String lastName;
    private String mobileNumber;
    private int  age;

    

@NotNull(message="Address field should not be null")

@OneToOne(cascade = CascadeType.ALL)
private  Address address;

@OneToOne
private User user;





}
