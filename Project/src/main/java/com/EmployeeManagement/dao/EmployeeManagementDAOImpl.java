package com.EmployeeManagement.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.EmployeeManagement.entity.DepartmentEntity;
import com.EmployeeManagement.entity.EmployeeEntity;
import com.EmployeeManagement.model.Department;
import com.EmployeeManagement.model.Employee;
@Repository(value="employeeManagementDAO")
public class EmployeeManagementDAOImpl implements EmployeeManagementDAO {
@PersistenceContext
private EntityManager entityManager;
@Override
public List<Employee> getEmployeesForManagerName(String mgname) throws Exception {
Query query = entityManager.createQuery("SELECT e FROM EmployeeEntity e where e.mgName=:r");
query.setParameter("r",mgname);
List<EmployeeEntity> employeeList = query.getResultList();
List<Employee> empList=new ArrayList();
for(EmployeeEntity emp : employeeList) {
Employee ee=new Employee();
ee.setEmpName(emp.getEmpName());
ee.setEmpNo(emp.getEmpNo());
ee.setJobType(emp.getJobType());
ee.setMgName(emp.getMgName());
ee.setSal(emp.getSal());
Department d=new Department();
d.setDeptno(emp.getDepartmentEntity().getDeptno());
d.setDname(emp.getDepartmentEntity().getDname());
ee.setDepartment(d);
empList.add(ee);
}
return empList;
}

@Override
public String getManagerForEmployeeId(Integer empno) throws Exception {
EmployeeEntity ee = entityManager.find(EmployeeEntity.class, empno);
String m=ee.getMgName();
return m;
}

@Override
public List<EmployeeEntity> getEmployeesInSameDepartment(int deptno) throws Exception {
	System.out.println("daooo");
Query query = entityManager.createQuery("SELECT e FROM EmployeeEntity e , Department d where e.deptNo= d.deptId and d.deptId=:r");
query.setParameter("r",deptno);
List<EmployeeEntity> empList =query.getResultList();
return empList;
}

@Override
public Integer adddEmployee(Employee employee) throws Exception {
Integer no=null;
EmployeeEntity ee=new EmployeeEntity();
ee.setEmpNo(employee.getEmpNo());
ee.setEmpName(employee.getEmpName());
ee.setJobType(employee.getJobType());
ee.setMgName(employee.getMgName());
ee.setSal(employee.getSal());
DepartmentEntity de=new DepartmentEntity();
de.setDeptno(employee.getDepartment().getDeptId());
de.setDname(employee.getDepartment().getDname());
ee.setDepartmentEntity(de);
entityManager.persist(ee);
no= ee.getEmpNo();
return no;
}

@Override
public String updateEmployee(Integer empno, String jobtype) throws Exception {
String jt = null;
Employee ee = entityManager.find(Employee.class, empno);
ee.setJobType(jobtype);
jt=ee.getJobType();

return jt;
}

@Override
public Integer deleteEmployee(Integer empno) throws Exception {
Integer no = null;
Employee ee = entityManager.find(Employee.class, empno);
entityManager.remove(ee);
no = ee.getEmpNo();
return no;
}

@Override
public Employee getEmployeeusingId(Integer empno) throws Exception {
Employee e= new Employee();
EmployeeEntity ee=entityManager.find(EmployeeEntity.class, empno);
if (ee != null) {
e.setEmpNo(ee.getEmpNo());
e.setEmpName(ee.getEmpName());
e.setJobType(ee.getJobType());
e.setMgName(ee.getMgName());
e.setSal(ee.getSal());
Department d=new Department();
d.setDeptno(ee.getDepartmentEntity().getDeptno());
d.setDname(ee.getDepartmentEntity().getDname());
e.setDepartment(d);
}
return e;
}
}
