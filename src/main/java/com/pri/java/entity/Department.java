package com.pri.java.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "DEPARTMENT")
@EntityListeners(AuditingEntityListener.class)
public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DEPT_ID")
	private Integer deptId;

	@Column(name = "DEPT_NAME")
	private String deptName;

	@Column(name = "DEPT_CODE")
	private String deptCode;

	public Department() {
	}

	public Department(Integer deptId, String deptName, String deptCode) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptCode = deptCode;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptCode=" + deptCode + "]";
	}

}
