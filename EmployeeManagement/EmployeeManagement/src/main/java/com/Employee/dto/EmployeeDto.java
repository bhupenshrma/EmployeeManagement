package com.Employee.dto;

import java.time.LocalDate;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.Employee.entity.Address;
import com.Employee.entity.Dapartment;

import lombok.Getter;
import lombok.Setter;

  
	@Getter
	@Setter
	public class EmployeeDto extends UserDto {
	    
	    @NotNull (message="DOB is required")  
	    private LocalDate dateOfJoining;
	    
	     @NotNull(message= "contact is required")
	     @Pattern (regexp= "[6789]{1}[0-9]{9}",message ="Invalid contact Details")
	     @Size(min=10, max=10,message="Min and Max. 10Digits allowed")
	    private String contact;
	     
	     @OneToOne
	     private Address address;
	     
	     @ManyToOne
	     private Dapartment dept;
	     
	}

