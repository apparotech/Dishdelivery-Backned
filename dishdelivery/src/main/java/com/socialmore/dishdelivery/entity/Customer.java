package com.socialmore.dishdelivery.entity;

import jakarta.persistence.CascadeType;
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
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Data;
@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Integer customerId;

 @NotNull(message = "firstName field should not be null")
 @Size(min = 3,max=30,message = "name of min length should be 3 and max be 30")
 private String firstName;

 @NotNull(message ="lastName field should not be null")
 @Size(min = 3,max=30,message = "name of min length should be 3 and max be 30")
 private String lastname;

 @NotNull(message= "age field should not be null")
 @Max(100)
 private Integer age;

 @NotNull(message = "gender field should not be null")
 private String gender;

 @NotNull(message = "mobileNumber field should not be null")
	private String mobileNumber;

@Email
private String email;


@NotNull(message="Address field should not be null")

@OneToOne(cascade = CascadeType.ALL)
private  Address address;

@NotNull(message= "Address field should not be null")
@Size(min = 8,max=15,message = "Password size of min length should be 3 and max be 30")
private String password;
    
}
