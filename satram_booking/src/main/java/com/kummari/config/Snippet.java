package com.kummari.config;

import org.springframework.stereotype.Component;

import com.kummari.mapper.UserMapper;

@Component
public class Snippet {
	public void DBInitializer(UserMapper userMapper) {
	    userMapper.createTable();
	}
	
}

