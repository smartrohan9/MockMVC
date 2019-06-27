package com.mock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mock.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
