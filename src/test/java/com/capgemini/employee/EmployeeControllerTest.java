package com.capgemini.employee;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.employee.controller.EmployeeController;
import com.capgemini.employee.entity.Employee;
import com.capgemini.employee.service.EmployeeService;


public class EmployeeControllerTest {

	@Mock
	public EmployeeService service;
	
	@InjectMocks
	private EmployeeController employeeController;
	private MockMvc mockMvc;
	Employee employee;
	@Before
	public void Setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
		employee = new Employee();
		employee.setEmployeeId(123);
		employee.setEmployeeName("sri");
		employee.setEmployeeDepartment("javacloud");
		employee.setEmployeeSalary(100000);
		
	}
	
	@Test
	public void testaddEmployee() throws Exception {
		
		when(service.addEmployee(Mockito.isA(Employee.class))).thenReturn(employee);
		
		mockMvc.perform(post("/employee").
		contentType(MediaType.APPLICATION_JSON_UTF8)
		.content("{\"employeeId\":\"123\",\"employeeName\":\"sri\",\"employeeDepartment\":\"javacloud\",\"employeeSalary\":\"100000\"}")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.employeeId").exists())
		.andExpect(jsonPath("$.employeeName").exists())
		.andExpect(jsonPath("$.employeeDepartment").exists())
		.andExpect(jsonPath("$.employeeSalary").exists());
		
	
	}
	
	}


