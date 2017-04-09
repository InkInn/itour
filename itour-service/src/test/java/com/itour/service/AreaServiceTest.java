package com.itour.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.test.context.ContextConfiguration;

import org.junit.Test;

import com.itour.api.model.Province;
import com.itour.api.service.AreaService;

@ContextConfiguration(locations = { "classpath:config/applicationContext_*.xml" })
public class AreaServiceTest {
	
	@Resource
	AreaService areaService;
	
	@Test
	public void testSelectPros(){
		List<Province> list = areaService.selectPros();
		System.out.println(list);
	}

}
