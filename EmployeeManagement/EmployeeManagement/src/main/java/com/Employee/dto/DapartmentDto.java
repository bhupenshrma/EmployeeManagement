package com.Employee.dto;

import java.util.List;

import javax.persistence.OneToMany;

import com.Employee.entity.Employee;

import lombok.Getter;
import lombok.Setter;

	@Getter
	@Setter
	public class DapartmentDto {
	  private String deptId;
	  
	  private String deptName;
	  
	  private int totalEmployee;
	  
	  private int noOfStaff;
	  
	  @OneToMany
	  private List<Employee> employee;
	}

