package com.Employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employee.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>  {

}
