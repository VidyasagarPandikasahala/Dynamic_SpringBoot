package com.greatlearning.employeemanagementservice.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.EncodedResourceResolver;

import com.greatlearning.employeemanagementservice.model.Role;
import com.greatlearning.employeemanagementservice.model.User;
import com.greatlearning.employeemanagementservice.repository.UserRepository;
import com.greatlearning.employeemanagementservice.service.UserStoreService;



@RestController
@RequestMapping("/security/save")
public class AdminController {
	
	@Autowired
	private  UserRepository userRepository;
	
	@Bean
	private PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	

	
	
	@PostMapping
	public String saveUserData(@RequestBody User user) {

		
		String username = user.getUsername();
		String password = user.getPassword();
		String encodedPassword= encoder().encode(password);
		Set<Role> role = user.getRoles();
		user.setUsername(username);
		user.setPassword(encodedPassword);

				
		user.setRoles(role);
	
		userRepository.save(user);
		return "success";

	}

}
