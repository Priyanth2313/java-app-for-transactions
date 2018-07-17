package com.hcl.java.repository;

import java.util.List;

import com.hcl.java.entity.Employee;
import com.hcl.java.exception.EmployeeException;

public interface IEmployeeDAO {

	public void saveEmployee(Employee emp) throws EmployeeException;

	public Employee getEmployee(Integer empId) throws EmployeeException;

	public List<Employee> getAllEmployees() throws EmployeeException;

	public void addAllEmployee(List<Employee> empList) throws EmployeeException;

	public void deleteEmployee(Integer id) throws EmployeeException;

	public void updateEmployee(Employee emp) throws EmployeeException;
}
