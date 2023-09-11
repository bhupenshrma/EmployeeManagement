package com.Employee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Service.DapartmentService;
import com.Employee.dto.DapartmentDto;
import com.Employee.entity.Dapartment;
import com.Employee.util.DapartmentConverter;


@RestController
public class DapartmentController {

	@Autowired
	DapartmentService deptService;
	
	@Autowired
	DapartmentConverter deptConverter;
	
	
	@PostMapping("/saveDept")
	public DapartmentDto saveDeparment(@Valid @RequestBody DapartmentConverter dDto) {
		
		final Dapartment dept =deptConverter.convertDtoToDeptEntity(dDto);
		
		return deptService.saveDapartment(dept);
		
	}
	
	@PostMapping("/assignStd/{sId}/toDept/{dId}")
	public ResponseEntity<String> assignStudentToDept(@PathVariable("sId") String stdId,
			@PathVariable("dId") String deptId){
		
		
		deptService.assignEmployeeToDept(stdId, deptId);
		
		
		return new ResponseEntity<String>("Employee with id"+stdId+
				"assigned to department id"+deptId,HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
}
