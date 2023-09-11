package com.Employee.Service;

import com.Employee.dto.DapartmentDto;
import com.Employee.entity.Dapartment;

public interface DapartmentService {


	DapartmentDto saveDapartment(Dapartment dept);
	

	void assignEmployeeToDept(String empId, String deptId);



}
