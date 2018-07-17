package com.hcl.java.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.java.entity.Employee;
import com.hcl.java.exception.EmployeeException;
import com.hcl.java.repository.IEmployeeDAO;
import com.hcl.java.service.IEmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDAO employeeDAO;

	@Override
	public void saveEmployee(Employee emp) throws EmployeeException {
		employeeDAO.saveEmployee(emp);
	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
	public Employee getEmployee(Integer empId) throws EmployeeException {
		return employeeDAO.getEmployee(empId);
	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
	public List<Employee> getAllEmployees() throws EmployeeException {
		return employeeDAO.getAllEmployees();
	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
	public void addAllEmployee(List<Employee> empList) throws EmployeeException {
		employeeDAO.addAllEmployee(empList);
	}

	@Override
	public void deleteEmployee(Integer id) throws EmployeeException {
		employeeDAO.deleteEmployee(id);
	}

	@Override
	public void updateEmployee(Employee emp) throws EmployeeException {
		employeeDAO.updateEmployee(emp);
	}
}
