package com.greatlearning.employeemanagementservice.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagementservice.model.Role;
import com.greatlearning.employeemanagementservice.model.User;

import com.greatlearning.employeemanagementservice.repository.UserRepository;

@Service
public class UserStoreServiceImpl implements UserStoreService {

	@Autowired
	private UserRepository userRepo;
	

	@Override
	public String saveUser(User user) {
//		Role roles = new Role();
//		roles.setUser(user);

		
		

		this.userRepo.save(user);

		
		return "Success";
		// TODO Auto-generated method stub

	}

}
