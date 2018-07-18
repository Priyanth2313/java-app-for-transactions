package com.pri.java.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pri.java.entity.Department;
import com.pri.java.exception.DepartmentException;
import com.pri.java.repository.IDepartment;

@Repository
public class DepartmentImpl implements IDepartment {

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DepartmentException.class)
	public void saveDept(Department dept) throws DepartmentException {

		int i = 0;
		i++;
		if (i == 1) {
			throw new DepartmentException();
		} else {
			entityManager.persist(dept);
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DepartmentException.class)
	public void saveDeptList(List<Department> dept) {
		int count = 0;
		
		if(count <3) {
			for (Department department : dept) {
				entityManager.persist(department);
				count ++;
			}
		} else {
			throw new RuntimeException();
		}

	}

}
