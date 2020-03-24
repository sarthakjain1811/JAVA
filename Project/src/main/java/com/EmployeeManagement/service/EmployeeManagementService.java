package com.EmployeeManagement.service;

	import java.util.List;

import com.EmployeeManagement.entity.EmployeeEntity;
import com.EmployeeManagement.model.Employee;

	public interface EmployeeManagementService {
	public List<Employee> getEmployeesForManagerName(String mgname ) throws Exception;
	public String getManagerForEmployeeId(Integer empno) throws Exception;
	public List<EmployeeEntity>getEmployeesInSameDepartment(int deptno) throws Exception;
	public Integer adddEmployee(Employee employee) throws Exception;
	public String updateEmployee(Integer empno, String jobtype)throws Exception;
	public Integer deleteEmployee(Integer empno)throws Exception;
	public Employee getEmployeeusingId(Integer empno) throws Exception;
}
