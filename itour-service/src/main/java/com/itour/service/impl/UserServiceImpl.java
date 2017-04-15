package com.itour.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itour.api.dao.UserDao;
import com.itour.api.model.User;
import com.itour.api.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public void register(User user) {
		userDao.insert(user);
	}

	public User findUser(String loginName) {
		User user = userDao.findUser(loginName);
		return user;
	}

}
