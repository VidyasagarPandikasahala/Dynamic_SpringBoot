package com.greatlearning.employeemanagementservice.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(of= "role_id")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long role_id;
	private String roleName;
	
	
	@ManyToMany(mappedBy ="roles",fetch=FetchType.LAZY)
	
	 private Set<User> user;
}