package com.entityRelationship.Employee.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entityRelationship.Employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

}
