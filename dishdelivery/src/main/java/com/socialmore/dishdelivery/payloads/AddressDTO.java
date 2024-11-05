package com.socialmore.dishdelivery.payloads;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    
    private Integer addressId;

    private  String buildingName;
	
	private String streetNo;
	
	private String area;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String pinCode;
}
