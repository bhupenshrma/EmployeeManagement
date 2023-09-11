package com.Employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Employee.entity.Dapartment;

public interface DapartmentRepository extends JpaRepository<Dapartment, String>  {

	

	Dapartment findByDeptName(String deptName);
	
	@Query("Select max(deptId)from Dapartment")
	String getLastAddedId();

}
