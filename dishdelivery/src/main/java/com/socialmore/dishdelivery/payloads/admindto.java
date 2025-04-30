package com.socialmore.dishdelivery.payloads;
import jakarta.persistence.Id;
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
public class admindto {

    

    private Integer  adminId;
    private String username;
    private String password;

}
