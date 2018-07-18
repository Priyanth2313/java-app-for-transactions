package com.pri.java.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pri.java.entity.Employee;
import com.pri.java.exception.EmployeeException;
import com.pri.java.repository.IEmployee;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private IEmployee empRepo;
	
	@GetMapping("/healthCheck")
	private String healthCheck() {
		return "Hello";
	}
	
	
	@PostMapping("/createEmployee")
	public ResponseEntity<?> createEmployee(@RequestBody Employee emp) {
		try {
			empRepo.saveEmployee(emp);
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().build();
	}

	@PostMapping("/addEmployeeList")
	public ResponseEntity<?> addAllEmployees(@Valid @RequestBody List<Employee> empList) {
		try {
			empRepo.addAllEmployee(empList);
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().build();

	}

	@GetMapping("/employeeList")
	public List<Employee> getAllEmployees() {
		List<Employee> empList = null;
		try {
			empList = empRepo.getAllEmployees();
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empList;
	}

	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable(value = "id") Integer empId) {
		Employee emp = null;
		try {
			emp = empRepo.getEmployee(empId);
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@PutMapping("/employee/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable(value = "id") Integer empId, @RequestBody Employee empInfo) {
		try {
			empRepo.updateEmployee(empId, empInfo);
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Integer empId) {

		try {
			empRepo.deleteEmployee(empId);
		} catch (EmployeeException e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok().build();
	}

}
