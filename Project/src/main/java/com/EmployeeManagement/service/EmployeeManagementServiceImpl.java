package com.EmployeeManagement.service;

	import java.util.ArrayList;
	import java.util.List;

	import javax.transaction.Transactional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.EmployeeManagement.dao.EmployeeManagementDAO;
import com.EmployeeManagement.entity.EmployeeEntity;
import com.EmployeeManagement.model.Employee;
	@Transactional
	@Service(value="employeeManagementService")
	public class EmployeeManagementServiceImpl implements EmployeeManagementService {
	@Autowired
	private EmployeeManagementDAO employeeManagementDAO;
	@Override
	public List<Employee> getEmployeesForManagerName(String mgname) throws Exception {
	List list=new ArrayList();
	list=employeeManagementDAO.getEmployeesForManagerName(mgname);
	if(list==null) {
	throw new Exception("Service.MANAGER_UNAVAILABLE");
	}
	return list;
	}

	@Override
	public String getManagerForEmployeeId(Integer empno) throws Exception {
		System.out.println("yyy");
	String s= employeeManagementDAO.getManagerForEmployeeId(empno);
	if(s == null) {
	throw new Exception("Service.EMPLOYEE_UNAVAILABLE");
	}

	return s;
	}

	@Override
	public List<EmployeeEntity> getEmployeesInSameDepartment(int deptno) throws Exception {
	List list=new ArrayList();
	list=employeeManagementDAO.getEmployeesInSameDepartment(deptno);
	if(list==null) {
	throw new Exception("Service.DEPARTMENT_UNAVAILABLE");
	}
	return list;
	}

	@Override
	public Integer adddEmployee(Employee employee) throws Exception {
	return employeeManagementDAO.adddEmployee(employee);
	}

	@Override
	public String updateEmployee(Integer empno, String jobtype) throws Exception {
	Employee e=new Employee();
	   e = employeeManagementDAO.getEmployeeusingId(empno);
	if(e== null) {
	throw new Exception("Service.EMPLOYEE_UNAVAILABLE");}

	return employeeManagementDAO.updateEmployee(empno, jobtype);
	}

	@Override
	public Integer deleteEmployee(Integer empno) throws Exception {
	Employee e=new Employee();
	   e = employeeManagementDAO.getEmployeeusingId(empno);
	if(e== null) {
	throw new Exception("Service.EMPLOYEE_UNAVAILABLE");
	}

	return employeeManagementDAO.deleteEmployee(empno);
	}

	@Override
	public Employee getEmployeeusingId(Integer empno) throws Exception {
	Employee employee = employeeManagementDAO.getEmployeeusingId(empno);
	if (employee == null) {
	throw new Exception("Service.EMPLOYEE_UNAVAILABLE");
	}
	return employee;
	}

	}

