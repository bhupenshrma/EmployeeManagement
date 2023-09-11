package com.Employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employee.entity.Address;

public interface AddressRepository extends JpaRepository<Address, String>  {

}
