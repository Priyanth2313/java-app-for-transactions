package com.pri.java.repository;

import java.util.List;

import com.pri.java.entity.Department;
import com.pri.java.exception.DepartmentException;

public interface IDepartment {
	
	public void saveDept(Department dept) throws DepartmentException;

	public void saveDeptList(List<Department> dept)throws DepartmentException;

}
