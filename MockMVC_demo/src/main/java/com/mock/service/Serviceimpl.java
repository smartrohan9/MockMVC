package com.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.model.Employee;
import com.mock.model.Respoce;
import com.mock.repository.EmployeeRepository;

@Service
public class Serviceimpl implements ServiceI {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public Respoce saveemployee(Employee e) {
		repo.save(e);
		return new Respoce(e.getEmpid() + "inserted", Boolean.TRUE);

	}

	@Override
	public Respoce getdata() {
		List<Employee>employees=repo.findAll();
		return new Respoce("record counts : "+employees.size(),Boolean.TRUE);
	}
}
