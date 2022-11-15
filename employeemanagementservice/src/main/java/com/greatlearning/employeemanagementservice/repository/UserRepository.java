package com.greatlearning.employeemanagementservice.repository;

import java.util.Optional;



import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.employeemanagementservice.model.User;




@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u FROM User u WHERE u.username = ?1")
	public Optional<User>  findByUsername(String username);
}
