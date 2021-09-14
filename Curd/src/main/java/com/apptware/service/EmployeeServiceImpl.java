package com.apptware.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apptware.model.Employee;
import com.apptware.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo empRepo;
	@Override
	public void addEmployee(Employee employee) {
		empRepo.save(employee);
	}
	@Override
	public Optional<Employee> getById(int id) {	
		return empRepo.findById(id);
	}
	@Override
	public void deleteById(int id) {
		empRepo.deleteById(id);
	}

}
