package com.lt.journey.service;

import com.lt.journey.model.User;

public interface UserService{
    
    User findUserByPhone(String mobile);

	void addUser(User user);

	User findUserByUsername(String username);
    
}