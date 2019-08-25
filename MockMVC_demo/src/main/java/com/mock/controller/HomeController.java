package com.mock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mock.model.Employee;
import com.mock.model.Respoce;
import com.mock.service.ServiceI;


@RestController
public class HomeController {

	@Autowired
 private ServiceI serviceimpl;
	
	@RequestMapping("/abc")
	public String data() {
		
		System.out.println("fsadgasdf");
		
		System.out.println(1.55555);
		
		return "dsfasdfa";
	}
	
	@PostMapping("/saveemployee")
	public Respoce regesteremployee(@RequestBody Employee e) {
		
	System.out.print("kdsjfashdbndkf");
		return serviceimpl.saveemployee(e);
		
	}
	
	@GetMapping("/getemployeedata")
	public Respoce fetchdata() {
		return serviceimpl.getdata();
	}
	
	
}
