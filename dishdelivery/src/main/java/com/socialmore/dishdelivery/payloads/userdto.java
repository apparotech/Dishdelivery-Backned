package com.socialmore.dishdelivery.payloads;

import java.util.Set;

import com.socialmore.dishdelivery.enuk.Role;
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
public class userdto {
    
    private String username; // Required for user creation
    private String password; // Required for user creation
    private Set<Role> roles; 
}
