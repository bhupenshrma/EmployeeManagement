package com.Employee.ServiceImpl;



	import java.util.ArrayList;
	import java.util.List;

	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.dao.DataIntegrityViolationException;
	import org.springframework.stereotype.Service;

	import com.Employee.Service.EmployeeService;
import com.Employee.dto.EmployeeDto;
import com.Employee.entity.Address;
import com.Employee.entity.Employee;
import com.Employee.entity.Role;
import com.Employee.repository.AddressRepository;
import com.Employee.repository.DapartmentRepository;
import com.Employee.repository.EmployeeRepository;
import com.Employee.repository.RoleRepository;
import com.Employee.util.EmployeeConverter;
import com.Employee.Exception.ResourceNotFoundException;
import com.Employee.entity.Dapartment;

	
	@Service

	public class EmployeeServiveImpl implements EmployeeService {

		// logger statically created
		private static final Logger log = LoggerFactory.getLogger(Employee.class);

		@Autowired
		EmployeeRepository empRepository;

		@Autowired
		EmployeeConverter empConverter;

		@Autowired
		DapartmentRepository deptRepository;

		@Autowired
		RoleRepository roleRepository;

		@Autowired
		AddressRepository addRepository;

	
		@Override
		public EmployeeDto saveEmployee(Employee emp) {
			String lastAdded = empRepository.getLastAddedId();

			if (lastAdded == null) {

				lastAdded = "S00";
			}

			String initial = lastAdded.substring(0, 2);

			int num = Integer.parseInt(lastAdded.substring(2));
			lastAdded = initial + (num + 1);
			emp.setId(lastAdded);

			String user = emp.getEmail().substring(0, emp.getEmail().indexOf('@'));
			emp.setUserName(user);

			String pass = emp.getName().substring(0, 3).toLowerCase();
			emp.setPassword(pass + "123");

			// setting role
			Role role = roleRepository.findById(2).get();
			emp.setRole(role);

			//
			Address address = addRepository.save(emp.getAddress());
			emp.setAddress(address);

			Employee existStd = empRepository.findByEmailOrContact(emp.getEmail(), emp.getContact());

			if (existStd != null) {

				throw new DataIntegrityViolationException("check your contact and email");
			}

			empRepository.save(emp);

			log.info("Employee with details " + emp.toString() + "save ssuccessfully!");

			EmployeeDto eDto = empConverter.convertEntityToEmpDto(emp);
			return eDto;

		}
		
		@Override
		public EmployeeDto getEmployeById(String empId) throws ResourceNotFoundException {
			Employee emp = empRepository.findById(empId)
					.orElseThrow(() -> new ResourceNotFoundException("Student", "id", empId));

			return empConverter.convertEntityToEmpDto(emp);
		}

		@Override
		public List<EmployeeDto> getAllEmployee() {

			List<Employee> employee = empRepository.findAll();
			List<EmployeeDto> eDtos = new ArrayList<>();

			for (Employee e : employee) {

				EmployeeDto eDto = empConverter.convertEntityToEmpDto(e);
				eDtos.add(eDto);

			}

			return eDtos;
		}

		@Override
		public EmployeeDto updateEmployee(String empId, Employee emp) throws ResourceNotFoundException {

			Employee existEmp = empRepository.findById(empId)
					.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));

			existEmp.setName(emp.getName());
			existEmp.setEmail(emp.getEmail());
			existEmp.setAddress(emp.getAddress());
			existEmp.setContact(emp.getContact());
			existEmp.setDateOfJoining(emp.getDateOfJoining());

			// saving the changes made
			empRepository.save(existEmp);

			return empConverter.convertEntityToEmpDto(existEmp);
		}

		@Override // it should use in project
		public void deleteEmployeeById(String empId) {
			
			Employee emp = empRepository.findById(empId)
					.orElseThrow(() -> new ResourceNotFoundException("Employee", "id",empId));

			Dapartment dept = emp.getDept();

			Address add = emp.getAddress();
			if (add != null) {

				emp.setAddress(null);
				addRepository.delete(add);
			}

			if (dept != null) {
				dept.setTotalEmployee(dept.getTotalEmployee() - 1);
			}

			deptRepository.save(dept);
			empRepository.delete(emp);

		}

		@Override
		public void deleteAll() {

			empRepository.deleteAll();
		}

		@Override
		public List<EmployeeDto> getEmployeeByName(String name) {

			List<Employee> employee = empRepository.findEmployeeByName(name);

			List<EmployeeDto> eDtos = new ArrayList<>();

			for (Employee e : employee) {

				EmployeeDto eDto = empConverter.convertEntityToEmpDto(e);
				eDtos.add(eDto);

			}

			return eDtos;
		}

		@Override
		public EmployeeDto getEmployeeByEmail(String email) {

			Employee emp = empRepository.findByEmail(email)
					.orElseThrow(() -> new ResourceNotFoundException("Employee", "email", email));

			return empConverter.convertEntityToEmpDto(emp);
		}

		@Override
		public List<EmployeeDto> getEmployeeByDeptId(String deptId) {

			List<Employee> employee = empRepository.getEmployeeByDeptId(deptId);

			List<EmployeeDto> eDtos = new ArrayList<>();

			for (Employee e : employee) {

			
				eDtos.add(empConverter.convertEntityToEmpDto(e));
			}

			return eDtos;
		
		}
		}