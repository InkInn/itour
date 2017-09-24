package com.itour.service;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.alibaba.fastjson.JSON;
import com.itour.api.model.Province;
import com.itour.api.service.AreaService;
import com.itour.api.service.TestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/applicationContext_*.xml" })
public class AreaServiceTest {
	
	@Autowired
	AreaService areaService;
	
	@Autowired
	TestService testService;
	
	@Test
	public void testSelectPros(){
		System.out.println("***********************");
		List<Province> list = areaService.selectPros();
		System.out.println(JSON.toJSONString(list));
	}
	
	
	@Test
	public void test(){
		testService.test();
	}

}
