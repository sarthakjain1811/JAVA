package com.EmployeeManagement.entity;

	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name="Department")
	public class DepartmentEntity {
	@Id
	private int deptId;
	private String dName;

	public int getDeptno() {
	return deptId;
	}
	public void setDeptno(int deptId) {
	this.deptId = deptId;
	}
	public String getDname() {
	return dName;
	}
	public void setDname(String dName) {
	this.dName = dName;
	}

	}

