package com.Employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employee.entity.User;

public interface UserRepository extends JpaRepository<User, String>  {

}
