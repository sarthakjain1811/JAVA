package com.EmployeeManagement.model;

public class Employee {
	private int empNo;
	private String empName;
	private String jobType;
	private String mgName;
	private float sal;
	private Department department;
	public int getEmpNo() {
	return empNo;
	}
	public void setEmpNo(int empNo) {
	this.empNo = empNo;
	}
	public String getEmpName() {
	return empName;
	}
	public void setEmpName(String empName) {
	this.empName = empName;
	}
	public String getJobType() {
	return jobType;
	}
	public void setJobType(String jobType) {
	this.jobType = jobType;
	}

	public String getMgName() {
	return mgName;
	}
	public void setMgName(String mgName) {
	this.mgName = mgName;
	}
	public float getSal() {
	return sal;
	}
	public void setSal(float sal) {
	this.sal = sal;
	}
	public Department getDepartment() {
	return department;
	}
	public void setDepartment(Department department) {
	this.department = department;
	}


	}
