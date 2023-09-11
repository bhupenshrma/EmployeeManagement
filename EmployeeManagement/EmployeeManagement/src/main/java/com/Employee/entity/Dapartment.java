package com.Employee.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Dapartment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String deptId;
	
	@Column(length = 30, nullable = false ,unique = true)
	private String deptName;
	
	@Column(nullable = false)
	private int totalEmployee;
	
	@Column(nullable = false)
	private int noOfstaff;
	
	@OneToMany  //one department has many Employee
	private List<Employee> employee;


}

