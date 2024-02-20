package com.chandra.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chandra.security.entity.Employee;

public interface EmpRepository  extends JpaRepository<Employee, Integer>{
	
	public Employee findByEmail( String email);

}
