package com.kummari.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kummari.model.User;

@Mapper
public interface UserMapper {
	
	void createTable();
	void insertUser(User user);

    User findByEmail(@Param("email") String email);

    User findById(@Param("id") Long id);
}
