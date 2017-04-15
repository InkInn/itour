package com.itour.api.dao;

import com.itour.api.model.User;

public interface UserDao {
	
	public void insert(User user);
	
	public User findUser(String loginName);
}
