package com.Employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Service.EmployeeService;
import com.Employee.dto.EmployeeDto;
import com.Employee.entity.Employee;
import com.Employee.util.EmployeeConverter;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@Autowired
	EmployeeConverter empConverter;

	@PostMapping("/saveEmployee")
	public EmployeeDto saveEmployee(@Valid @RequestBody EmployeeDto emDto) {

		final Employee emp = empConverter.convertDtoToEmpEntity(emDto);
		return empService.saveEmployee(emp);

	}

	@GetMapping("/getEmployee/{empId}")
	public EmployeeDto getEmployeeById(@PathVariable("empId") String id) {

		return empService.getEmployeById(id);

	}

	@GetMapping("/getAllEmployee")
	public List<EmployeeDto> getAllEmployee() {

		return empService.getAllEmployee();
	}

	@PutMapping("/updateEmployee/{id}")
	public EmployeeDto updateEmployee(@PathVariable("id") String empid, @Valid @RequestBody EmployeeDto empDto) {
		final Employee emp = empConverter.convertDtoToEmpEntity(empDto);
		return empService.updateEmployee(empid, emp);
	}

	@DeleteMapping("/deleteEmpById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") String empId) {
		empService.deleteEmployeeById(empId);
		return new ResponseEntity<String>("Employee with id" + empId + "deleted Sucessfully!", HttpStatus.OK);
	}

	@DeleteMapping("deleteAll")
	public ResponseEntity<String> deleteAll() {
		empService.deleteAll();
		return new ResponseEntity<String>("All employee details deleted" + "Succesfully!", HttpStatus.OK);
	}
}
