package com.entityRelationship.Employee.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entityRelationship.Employee.dto.EmployeeDto;
import com.entityRelationship.Employee.service.EmployeeService;

@RestController
@RequestMapping("/api/EmployeeOnetoOne")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/post")
	public String postEmployee(@RequestBody EmployeeDto employeeDto) {
		employeeService.postEmployee(employeeDto);
		return "Data saved";
	}
	
	@PostMapping("/postlist")
	public String postList(@RequestBody List <EmployeeDto> employeeDto){
		employeeService.postList(employeeDto);
		return "Datas Saved";
	}
	
	@GetMapping("getbyid/{id}")
	public EmployeeDto getById(@PathVariable ("id") UUID id) {
		return employeeService.getById(id);
	}
	
	@DeleteMapping("deleteById/{id}")
	public String deleteById(@PathVariable ("id") UUID id) {
		employeeService.deleteById(id);
		return "successfully Deleted";
	}
	
	@GetMapping("getAll")
	public List<EmployeeDto> getAll(){
		return employeeService.getAll();
	}
	
}
