package com.itour.api.service;

import com.itour.api.model.User;

public interface UserService {
	public void register(User user);
	
	public User findUser(String loginName);
}
