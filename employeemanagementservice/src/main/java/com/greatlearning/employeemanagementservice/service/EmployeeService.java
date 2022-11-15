package com.greatlearning.employeemanagementservice.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagementservice.model.Employee;


@Service
public interface EmployeeService {
	
	
	
	public void saveEmployee(Employee employee);

	public Set<Employee> fetchAllEmployees();

	// Read
	public Employee fetchEmployeeById(long id);

	// Read
	public List<Employee> fetchEmployeeByName(String name);

	// Update
	public Employee updateEmployee(long id, Employee employee);

	// Delete
	public void deleteEmployeeById(long id);

	// FetchLibrarySortedByName
	public List<Employee> getEmployeeSortedByName(Direction direction);


}
