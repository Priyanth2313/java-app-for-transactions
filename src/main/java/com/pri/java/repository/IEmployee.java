package com.pri.java.repository;

import java.util.List;

import com.pri.java.entity.Employee;
import com.pri.java.exception.EmployeeException;

public interface IEmployee {
	

	public void saveEmployee(Employee emp) throws EmployeeException;

	public Employee getEmployee(Integer empId) throws EmployeeException;

	public List<Employee> getAllEmployees() throws EmployeeException;

	public void addAllEmployee(List<Employee> empList) throws EmployeeException;

	public void deleteEmployee(Integer id) throws EmployeeException;

	public void updateEmployee(Integer empId, Employee emp) throws EmployeeException;

}
