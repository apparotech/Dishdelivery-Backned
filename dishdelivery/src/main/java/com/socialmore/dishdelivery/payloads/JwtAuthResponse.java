package com.socialmore.dishdelivery.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class JwtAuthResponse {

    private String token;
    private userdto customer;
    
}
