package com.Employee.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.Employee.Service.DapartmentService;
import com.Employee.dto.DapartmentDto;
import com.Employee.entity.Dapartment;
import com.Employee.entity.Employee;
import com.Employee.repository.DapartmentRepository;
import com.Employee.repository.EmployeeRepository;
import com.Employee.util.DapartmentConverter;
import com.Employee.Exception.ResourceNotFoundException;

@Service
public class DaparmentServiceImpl implements DapartmentService {

	@Autowired
	DapartmentRepository deptRepository;

	@Autowired
	EmployeeRepository empRepository;

	@Autowired
	DapartmentConverter deptConverter;

	@Override
	public DapartmentDto saveDapartment(Dapartment dept) {

		Dapartment exitsDept = deptRepository.findByDeptName(dept.getDeptName());

		if (exitsDept != null) {

			throw new DataIntegrityViolationException("this  department name is already present ");

		}

		String lastAdded = deptRepository.getLastAddedId();

		if (lastAdded == null) {

			lastAdded = "D00";
		}

		String initial = lastAdded.substring(0, 2);

		int num = Integer.parseInt(lastAdded.substring(2));
		lastAdded = initial + (num + 1);
		dept.setDeptId(lastAdded);

		deptRepository.save(dept);

		return deptConverter.convertDeptEntityToDto(dept);
	}

	@Override
	public void assignEmployeeToDept(String empId, String deptId) {

		Employee emp = empRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));

		Dapartment dept = deptRepository.findById(deptId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));

		emp.setDept(dept);

		dept.setTotalEmployee(dept.getTotalEmployee() + 1);

		empRepository.save(emp);
		deptRepository.save(dept);

	}

}
