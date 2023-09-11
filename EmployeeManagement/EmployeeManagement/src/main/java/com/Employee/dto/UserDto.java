package com.Employee.dto;

import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.Employee.entity.Role;

import lombok.Getter;
import lombok.Setter;

	@Getter
	@Setter
	public class UserDto {
		private String id;

		@NotNull(message = "Name is Required")
		@Size(min = 2, message = "min 2 characters required")
		@Size(max = 30, message = "max 30 Characters Allowed")
		@NotBlank(message = "Invalid email")
		private String name;

		@Size(max = 50, message = "Max. 30 Characters allowed")
		@Email(message = "Invalid email")
		private String email;
		
		private String userName;
		
		private String password;
		
		  @OneToOne
		   private Role role;
	}


