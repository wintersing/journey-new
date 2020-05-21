package com.lt.journey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.journey.mapper.UserMapper;
import com.lt.journey.model.User;
import com.lt.journey.service.UserService;;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUserByPhone(String mobile) {
		return userMapper.findUserByPhone(mobile);
	}

	@Override
	public void addUser(User user) {
		userMapper.addUser(user);
	}

	@Override
	public User findUserByUsername(String username) {
		return userMapper.findUserByUsername(username);
	}

	
}