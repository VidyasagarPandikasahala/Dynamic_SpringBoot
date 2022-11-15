package com.greatlearning.employeemanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.employeemanagementservice.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
