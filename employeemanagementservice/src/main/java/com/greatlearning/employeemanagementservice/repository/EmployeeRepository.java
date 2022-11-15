package com.greatlearning.employeemanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.employeemanagementservice.model.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{	
	

}
