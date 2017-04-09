package com.itour.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.itour.api.service.TestService;
import com.itour.dto.JsonResultHaveObj;

@Controller
@RequestMapping(value = "/itour")
public class TestController {
	
	@Autowired
	TestService testService;
	
	@RequestMapping(value="/count",method=RequestMethod.GET,consumes = MediaType.ALL_VALUE)
	@ResponseBody
	JsonResultHaveObj<String>getTopicArchives(HttpServletRequest request){
		JsonResultHaveObj<String> ret=JsonResultHaveObj.getSuccessInstance();
		int count = testService.test();
		ret.setResult(JSON.toJSONString(count));
		return ret;
	}
}
