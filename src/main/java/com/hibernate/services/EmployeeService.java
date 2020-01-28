package com.hibernate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hibernate.models.Employee;
import com.hibernate.repositires.EmployeeRepository;

@Service
@CacheConfig(cacheNames = "employees",cacheManager = "cacheManager")
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Cacheable
	public List<Employee> getEmployee() {
		System.out.println("about to fetch data ");
		List<Employee> employees = employeeRepository.findAll();
		return employees;

	}

	@Cacheable( key = "#employeeId")
	public Employee getEmployeeById(Long employeeId) {
		System.out.println("Getting employee from database");
		Optional<Employee> emp = employeeRepository.findById(employeeId);
		return emp.orElse(null);
	}

}
