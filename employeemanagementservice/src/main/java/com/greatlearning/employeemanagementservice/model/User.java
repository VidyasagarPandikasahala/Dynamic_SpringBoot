package com.greatlearning.employeemanagementservice.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode(of = "userId")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private long userId;

	private String username;

	private String password;

	private String emailAddress;

	 @ManyToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinTable(
	           name = "users_roles",
	           joinColumns = {@JoinColumn(name = "user_id", referencedColumnName="user_id" )},
	           inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName="role_id")})
	  
	private Set<Role> roles;

	
}
