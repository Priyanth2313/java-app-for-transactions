package com.pri.java.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pri.java.entity.Department;
import com.pri.java.entity.Employee;
import com.pri.java.exception.DepartmentException;
import com.pri.java.exception.EmployeeException;
import com.pri.java.repository.IEmployee;

@Repository
//@Transactional
public class EmployeeImpl implements IEmployee{
	
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private DepartmentImpl deptRepo;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveEmployee(Employee emp) throws EmployeeException {
		
		 entityManager.persist(emp);
		 
		 Department deptObj = new Department();
		 deptObj.setDeptId(1);
		 deptObj.setDeptName("IT");
		 deptObj.setDeptCode("JAVA");
		 saveDept(deptObj);
	}

	@Override
	public Employee getEmployee(Integer empId) throws EmployeeException {
		Employee employee = entityManager.find(Employee.class, empId);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() throws EmployeeException {
		String query = "select w from Employee w";
		
		List<Employee> empList = null;
		
		 empList = entityManager.createNamedQuery(query, Employee.class).getResultList();
		 
		return empList;
	}

	@Override
	public void addAllEmployee(List<Employee> empList) throws EmployeeException {
		entityManager.persist(empList);
		
	}

	@Override
	public void deleteEmployee(Integer id) throws EmployeeException {
		entityManager.remove(id);
		
	}

	@Override
	public void updateEmployee(Integer id, Employee emp) throws EmployeeException {
		
		Employee updatedEmployee = entityManager.find(Employee.class, id);
		
		if(updatedEmployee == null) {
			throw new EmployeeException();
		} else {
			entityManager.merge(updatedEmployee);
		}
	}
	
	private void saveDept(Department dept) throws EmployeeException {
		try {
			deptRepo.saveDept(dept);
		} catch (DepartmentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void saveDeptList(List<Department> dept) throws EmployeeException {
		deptRepo.saveDeptList(dept);
		example();
	}


	
	private void example() {
		Department deptObj = new Department(2,"GS","fg");
		Department deptObj2 = new Department(2,"GS","fg");
		Department deptObj3 = new Department(2,"GS","fg");
		Department deptObj4 = new Department(2,"GS","fg");
		Department deptObj5 = new Department(2,"GS","fg");
		
		List<Department> deptList = new ArrayList<Department>();
		
		deptList.add(deptObj);
		deptList.add(deptObj2);
		deptList.add(deptObj3);
		deptList.add(deptObj4);
		deptList.add(deptObj5);
		
		try {
			saveDeptList(deptList);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
