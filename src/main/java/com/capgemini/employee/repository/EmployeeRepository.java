package com.capgemini.employee.repository;

import com.capgemini.employee.entity.Employee;

public interface EmployeeRepository {
	
	public Employee addEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public Employee deleteEmployee(int employeeId);
	public Employee findAllEmployeeById(int employeeId);

}
