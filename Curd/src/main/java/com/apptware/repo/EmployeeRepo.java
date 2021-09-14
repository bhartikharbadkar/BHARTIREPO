package com.apptware.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apptware.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
