package com.entityRelationship.Employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entityRelationship.Employee.dto.EmployeeDto;
import com.entityRelationship.Employee.entity.Employee;
import com.entityRelationship.Employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public Employee postEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employeeObj = new Employee();
		
		if(employeeDto != null) {
			Optional<Employee> employee1 = employeeRepository.findById(employeeDto.getId());
			employeeObj = employee1.get();
		}

		employeeObj.setName(employeeDto.getName());
		employeeObj.setJob(employeeDto.getJob());
		employeeObj.setNumber(employeeDto.getNumber());
		employeeObj.setAddress(employeeDto.getAddress());

		return employeeRepository.save(employeeObj);
	}

	public List <Employee> postList(List<EmployeeDto> employeeDto) {
		// TODO Auto-generated method stub
		
		List<Employee> employeeList = new ArrayList<>();
		
		for (EmployeeDto i : employeeDto) {
			Employee employeeObj = new Employee();
			employeeObj.setName(i.getName());
			employeeObj.setJob(i.getJob());
			employeeObj.setNumber(i.getNumber());
			employeeObj.setAddress(i.getAddress());
			employeeList.add(employeeObj);
		}
		return employeeRepository.saveAll(employeeList);
	}

	public EmployeeDto getById(UUID id) {
		// TODO Auto-generated method stub
		EmployeeDto employeeDto = new EmployeeDto();
		Optional<Employee> employee1 = employeeRepository.findById(id);
		Employee employee2 = employee1.get();
		employeeDto.setId(employee2.getId());
		employeeDto.setName(employee2.getName());
		employeeDto.setJob(employee2.getJob());
		employeeDto.setNumber(employee2.getNumber());
		employeeDto.setAddress(employee2.getAddress());
		return employeeDto;
	}

	public void deleteById(UUID id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		
	}

	public List<EmployeeDto> getAll() {
		// TODO Auto-generated method stub
		List<EmployeeDto> employeeDtoList = new ArrayList<>();
		for(Employee i : employeeRepository.findAll()) {
			EmployeeDto employeeDto =new EmployeeDto();
			employeeDto.setId(i.getId());
			employeeDto.setJob(i.getJob());
			employeeDto.setName(i.getName());
			employeeDto.setNumber(i.getNumber());
			employeeDto.setAddress(i.getAddress());
			employeeDtoList.add(employeeDto);
		}
		
		return employeeDtoList;
	}


}
