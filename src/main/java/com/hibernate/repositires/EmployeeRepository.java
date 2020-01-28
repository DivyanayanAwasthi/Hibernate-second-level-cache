package com.hibernate.repositires;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hibernate.models.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

}
