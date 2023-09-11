package com.Employee.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
 
	private String addid;
	
	@Size(max=100, message="Max. limit 100 characters")
	@NotNull(message="Locality is required")
	private String locality;
	
	@Size(max=50, message="MIn 2 Characters required")
	@Size(min=2, message="Min.2 Chartacters required")
	@NotNull(message="city id is required")
	private String city;
	
	@Size(max=30, message="Max limit 30 Characters")
	@Size(min=2, message="Min.3 Chartacters required")
	@NotNull(message="State id is required")	
	private String state;
	
	@Size(min=6, max=6, message="6 Characters required")
	@NotNull(message="Pincode is required")
	private int pincode;
}
