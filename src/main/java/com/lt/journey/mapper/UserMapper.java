package com.lt.journey.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.lt.journey.model.User;

@Repository
public interface UserMapper {
    
    @Select("SELECT * FROM user WHERE username=#{username}")
    User findUserByUsername(@Param("username") String username);
    
    @Select("SELECT * FROM user WHERE phone=#{mobile}")
    User findUserByPhone(@Param("mobile") String mobile);
    
	void addUser(User user);
	
}