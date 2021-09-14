package com.apptware.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apptware.model.Employee;
import com.apptware.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addEmployee(@RequestBody Employee employee) {
		String result=null;
		empService.addEmployee(employee);
		if(empService!=null)
		return result=" Sucessfully Added";
		else
		return result=" Not Added Sucessfully";	
	
	}
	
	@RequestMapping(value="/getById",method=RequestMethod.GET)
	public @ResponseBody Employee getById(@RequestParam ("id") int id){
		Optional<Employee> optional=empService.getById(id);
		Employee emp=new Employee();
		if(optional.isPresent()) {
			emp=optional.get();
		}
		return emp;
	}
	
	@RequestMapping(value="/deleteById",method=RequestMethod.GET)
	public @ResponseBody String deleteById(@RequestParam ("id") int id){
		Optional<Employee> optional=empService.getById(id);
		if(optional.isPresent()) {
			empService.deleteById(id);
			return "Deleted Successfully";
		}else {
			return "Id Not Found";
		}
	
	}
	
}
