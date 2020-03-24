package com.EmployeeManagement.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.EmployeeManagement.model.Employee;
import com.EmployeeManagement.service.EmployeeManagementService;
@CrossOrigin
@RestController
@RequestMapping("/employeemanagementapi")
public class SearchAPI {
	@Autowired
	private EmployeeManagementService empService;

	@Autowired
	private Environment environment;
	@GetMapping(value = "/viewMyManagerName/{empid}")
	public ResponseEntity<String> getManagerForEmployeeId(@PathVariable Integer empid)
	{
	try
	{
	String empName=empService.getManagerForEmployeeId(empid);
	return new ResponseEntity<String>(empName,HttpStatus.OK);
	}
	catch(Exception exception)
	{
	throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,environment.getProperty(exception.getMessage()));
	}
	}
	
	@RequestMapping(value = "/getEmployeesForManagerName/{mgname}", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getEmployeesForManagerName( @PathVariable String mgname)
	{
	try
	{
	List empList=empService.getEmployeesForManagerName(mgname);
	return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
	}
	catch(Exception exception)
	{
	throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,environment.getProperty(exception.getMessage()));
	}
	}
	
	@RequestMapping(value = "/getEployeesInSameDepartment/{deptno}", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getEmployeesInSameDepartment( @PathVariable int deptno)
	{
	try
	{
	List empList=empService. getEmployeesInSameDepartment(deptno);
	return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
	}
	catch(Exception exception)
	{
	throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,environment.getProperty(exception.getMessage()));
	}
	}
	
	
	
	
	
	
}
