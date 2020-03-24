package com.EmployeeManagement.entity;
import com.EmployeeManagement.entity.*;
	import javax.persistence.CascadeType;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import javax.persistence.Table;
	@Entity
	@Table(name="Employee")
	public class EmployeeEntity {
	@Id
	private int empNo;
	private String empName;
	private String jobType;
	private String mgName;
	private float sal;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="dept_no")
	private DepartmentEntity departmentEntity;
	public int getEmpNo() {
	return empNo;
	}
	public DepartmentEntity getDepartmentEntity() {
		return departmentEntity;
	}
	public void setDepartmentEntity(DepartmentEntity departmentEntity) {
		this.departmentEntity = departmentEntity;
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

}
