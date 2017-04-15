package com.itour.controller;


import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itour.api.model.User;
import com.itour.api.service.UserService;
import com.itour.dto.JsonResultHaveObj;

@Controller
@RequestMapping(value = "/itour/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/register",method=RequestMethod.GET,consumes = MediaType.ALL_VALUE)
	@ResponseBody
	JsonResultHaveObj<String>register(String loginName, String password, HttpServletRequest request){
		JsonResultHaveObj<String> ret=JsonResultHaveObj.getSuccessInstance();
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setLoginName(loginName);
		user.setPassword(password);
		userService.register(user);
		return ret;
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET,consumes = MediaType.ALL_VALUE)
	@ResponseBody
	JsonResultHaveObj<String>login(String loginName, String password, HttpServletRequest request){
		JsonResultHaveObj<String> ret=JsonResultHaveObj.getSuccessInstance();
		User user = userService.findUser(loginName);
		if(StringUtils.isEmpty(user.getPassword()) || (!password.equals(user.getPassword()))){
			ret.setResult("failed");
		}else{
			ret.setResult("success");
		}
		return ret;
	}
	
}
