package com.mock.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mock.model.Employee;
import com.mock.model.Respoce;



@RunWith(SpringRunner.class)
@SpringBootTest
public class MockitoDemoApplicationTests {

	private MockMvc mockmvc;
	
	@Autowired
	private WebApplicationContext contex;
	
	ObjectMapper om=new ObjectMapper();
	
	@Before
	public void setup() {
		mockmvc=MockMvcBuilders.webAppContextSetup(contex).build();
	}
	
	@Test
	public void regesteremployeeTest() throws Exception {
		Employee e=new Employee();
		e.setName("sagar");
		e.setMobile("940000000000000");
		e.setEmail("dsfadsfasf");
		System.out.println("in unit test case of post data");
		String jsonrequest=om.writeValueAsString(e);
		MvcResult result=mockmvc.perform(post("/saveemployee")
				.content(jsonrequest)
				.content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		
		
 		String resultContent=result.getResponse().getContentAsString();
		Respoce res=om.readValue(resultContent,Respoce.class);
		
		
		Assert.assertTrue(res.isStatus()==Boolean.TRUE);
	}
	@Test
	public void getmployeeTest() throws Exception {
	
		System.out.println("in unit test case of get data");
		
		MvcResult result=mockmvc.perform(get("/getemployeedata")
				.content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
	
		String resultContent=result.getResponse().getContentAsString();
		Respoce res=om.readValue(resultContent,Respoce.class);
		Assert.assertTrue(res.isStatus()==Boolean.TRUE);
	}
}
