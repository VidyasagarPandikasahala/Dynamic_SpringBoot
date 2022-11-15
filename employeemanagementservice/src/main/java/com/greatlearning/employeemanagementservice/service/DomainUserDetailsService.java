package com.greatlearning.employeemanagementservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagementservice.model.DomainUserDetails;
import com.greatlearning.employeemanagementservice.model.User;

import com.greatlearning.employeemanagementservice.repository.UserRepository;



@Service
public class DomainUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    
    private static UsernameNotFoundException invalidUser() {
        return new UsernameNotFoundException("Invalid User");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username).orElseThrow(DomainUserDetailsService::invalidUser);
        //convert into UserDetails object which Spring Security can understand
        return new DomainUserDetails(user);
    }

    	
    }

