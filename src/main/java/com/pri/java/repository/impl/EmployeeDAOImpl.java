package com.pri.java.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.pri.java.entity.Employee;
import com.pri.java.exception.EmployeeException;
import com.pri.java.repository.IEmployeeDAO;

/* All the database access logic is written here */

@Repository
// is a marker for any class that fulfills the role(DAO) of a repository. Translates exceptions
public class EmployeeDAOImpl implements IEmployeeDAO {
	

	@PersistenceContext
	private EntityManager entityMgr;

	@Override
	public void saveEmployee(Employee emp) throws EmployeeException {
		entityMgr.persist(emp);
	}

	@Override
	public Employee getEmployee(Integer empId) throws EmployeeException {
		return entityMgr.find(Employee.class, empId);
	}

	@Override
	public List<Employee> getAllEmployees() throws EmployeeException {
		return entityMgr.createNamedQuery("Employee.findAll", Employee.class).getResultList();
	}

	@Override
	public void addAllEmployee(List<Employee> empList) throws EmployeeException {
		entityMgr.persist(empList);
	}

	@Override
	public void deleteEmployee(Integer id) throws EmployeeException {
		Employee emp = getEmployee(id);
		if (emp == null) {
			throw new EmployeeException("Employee with id: " + id + " is not found in the DB");
		} else {
			entityMgr.remove(emp);
		}
	}

	@Override
	public void updateEmployee(Employee emp) throws EmployeeException {
		Employee updatedEmp = getEmployee(emp.getEmployeeId());
		if (updatedEmp == null) {
			throw new EmployeeException("Employee not found with id: " + emp.getEmployeeId());
		} else {
			updatedEmp.setFirstName(emp.getFirstName());
			updatedEmp.setLastName(emp.getLastName());
			updatedEmp.setEmail(emp.getEmail());

			entityMgr.merge(updatedEmp);
		}

	}

}