package com.greatlearning.employeemanagementservice.service;
import com.greatlearning.employeemanagementservice.model.User;


import org.springframework.stereotype.Service;



@Service
public interface UserStoreService {
	
	public String saveUser(User user);

}
