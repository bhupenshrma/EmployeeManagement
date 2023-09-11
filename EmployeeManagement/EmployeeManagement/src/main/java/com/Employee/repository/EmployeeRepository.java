package com.Employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Employee.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, String> { 

	@Query("from Employee where name = :e ")
	List<Employee> findEmployeeByName(@Param("e") String name);

	Optional<Employee> findByEmail(String email);

	// custom method to fetch Employee details belonging to a department
	// by using department

	@Query("from Employee where dept = (from Department where deptId = :id)")
	List<Employee> getEmployeeByDeptId(@Param("id") String deptId);

	Employee findByEmailOrContact(String email, String contact);

	@Query("select max(id) from Employee")
	String getLastAddedId();

}
