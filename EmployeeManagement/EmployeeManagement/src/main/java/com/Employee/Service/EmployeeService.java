package com.Employee.Service;

import java.util.List;

import com.Employee.Exception.ResourceNotFoundException;
import com.Employee.dto.EmployeeDto;
import com.Employee.entity.Employee;


public interface EmployeeService {

EmployeeDto saveEmployee(Employee emp);
	
	//method to fetch Employee details using id
    EmployeeDto getEmployeById(String emp) throws ResourceNotFoundException;
    
    //method to fetch all Employee details
    List<EmployeeDto> getAllEmployee();
    
    //method to update Employee details that are present in the database
     EmployeeDto updateEmployee(String empId,Employee emp);
     
     //method to delete one employee details
     void deleteEmployeeById(String empId);
     
     //method to delete all the employee from the database
     void deleteAll();
     
     //method to fetch employee details using name
     List<EmployeeDto> getEmployeeByName(String name);
     
     
     //method to fetch employee details using email
     EmployeeDto getEmployeeByEmail(String email);
     
     
     //method to fetch employee details from a department using deptId
     List<EmployeeDto> getEmployeeByDeptId(String deptId);
}
