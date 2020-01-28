package com.hibernate.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.models.Employee;
import com.hibernate.repositories.EmployeeRepository;
import com.hibernate.services.EmployeeService;

@EnableCaching
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	

	@GetMapping
	public List<Employee> getEmployee() {
		
		System.out.println("get employee invoked");
		return employeeService.getEmployee();

	}
	
	@GetMapping(value = "/employee/{employeeId}")
	public Employee getCachedEmployess(@PathVariable("employeeId") Long employeeId){
		
		Employee employee =  employeeService.getEmployeeById(employeeId);
		return employee;
		
	}

}
