package com.socialmore.dishdelivery.payloads;

import org.aspectj.bridge.Message;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Customerdto {

   private Integer  customerId;

   @NotNull(message = "firstName field should not be null")
   @Size(min = 3, max = 30, message = "First name should be between 3 and 30 characters")
   private String firstname;

   @NotNull(message = "lastName field should not be null")
   @Size(min = 3, max = 30, message = "Last name should be between 3 and 30 characters")
   private String lastName;
   

    @NotNull(message = "age field should not be null")
    @Max(value = 100, message = "Age should be less than or equal to 100")
    private Integer age;


    @NotNull(message = "gender field should not be null")
    private String gender;

    @NotNull(message = "mobileNumber field should not be null")
    private String mobileNumber;

    @Email(message = "Email should be valid")
    private String email;

    // Address can either be represented as a simple string or another DTO for deeper structure
    @NotNull(message = "Address field should not be null")
    private AddressDTO address;

    @NotNull(message = "password field should not be null")
    @Size(min = 8, max = 15, message = "Password should be between 8 and 15 characters")
    private String password;
    
}
