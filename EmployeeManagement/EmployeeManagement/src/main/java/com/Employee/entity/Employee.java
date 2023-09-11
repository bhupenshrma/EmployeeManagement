package com.Employee.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Employee extends User {

	@Column(nullable = false)
	private LocalDate dateOfJoining;
	
	@Column(length = 10,nullable = false ,unique = true)
	private String contact;
	
	@OneToOne  //one employee can only have one address
	private Address address;
	

	@ManyToOne  //many employee belongs to one department
	private Dapartment dept;
	
	public Employee(String id, String name, String email, String userName, String password, 
			 LocalDate dateOfJoining,String contact, Address address, Role role) {
		  super();
		       this.dateOfJoining=dateOfJoining;
		       this.contact=contact;
		       this.address=address;
		       
		  
	}
}
