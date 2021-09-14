package com.apptware.service;

import java.util.Optional;

import com.apptware.model.Employee;

public interface EmployeeService {

	void addEmployee(Employee employee);

	Optional<Employee> getById(int id);

	void deleteById(int id);

}
