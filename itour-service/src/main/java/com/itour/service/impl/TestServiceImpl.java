package com.itour.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itour.api.dao.TestDao;
import com.itour.api.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {

	@Resource
	TestDao testDao;
	
	public int test() {
		int count = testDao.testInsert();
		return count;
	}
}
