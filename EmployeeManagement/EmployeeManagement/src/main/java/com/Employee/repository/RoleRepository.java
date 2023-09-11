package com.Employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employee.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
