package com.Employee.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.Employee.dto.EmployeeDto;
import com.Employee.entity.Employee;

@Component
public class EmployeeConverter {

	// method to convert dto to employee entity
	public Employee convertDtoToEmpEntity(EmployeeDto eDto) {
		Employee emp = new Employee();

		if (eDto != null) {

			BeanUtils.copyProperties(eDto, emp);

		}

		return emp;

	}

	// method to convert Employee entity to dto

	public EmployeeDto convertEntityToEmpDto(Employee emp) {
		EmployeeDto eDto = new EmployeeDto();

		if (emp != null) {
			BeanUtils.copyProperties(emp, eDto);

		}
		return eDto;
	}

}
