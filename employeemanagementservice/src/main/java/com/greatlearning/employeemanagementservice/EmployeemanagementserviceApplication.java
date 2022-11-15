package com.greatlearning.employeemanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@EnableAutoConfiguration
@ComponentScan("com.greatlearning.employeemanagementservice")
@SpringBootApplication
public class EmployeemanagementserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagementserviceApplication.class, args);
	}

}
