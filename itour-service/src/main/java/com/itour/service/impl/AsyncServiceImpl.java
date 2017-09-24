package com.itour.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.itour.api.service.AsyncService;
import com.itour.api.service.TestService;


@Service("asyncService")
@Lazy
public class AsyncServiceImpl implements AsyncService{
	
	@Autowired
	private TestService testService;
	
	@Async("myexecutor")
	public void asyncMethod() {
		System.out.println("asyncMethod");
	}
	
}
