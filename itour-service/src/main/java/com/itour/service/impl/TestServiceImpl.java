package com.itour.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.itour.api.dao.TestDao;
import com.itour.api.service.AsyncService;
import com.itour.api.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {

	@Autowired
	@Lazy
	private AsyncService asyncService;

	public int test() {
		asyncService.asyncMethod();
		return 0;
	}
}
