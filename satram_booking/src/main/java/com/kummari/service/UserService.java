package com.kummari.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kummari.dto.LoginRequest;
import com.kummari.dto.RegisterRequest;
import com.kummari.mapper.UserMapper;
import com.kummari.model.User;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public String register(RegisterRequest request) {

        User existing = userMapper.findByEmail(request.getEmail());
        if (existing != null) {
            return "Email already registered";
        }

        User user = new User();
        user.setName(request.getName());
        user.setPhone(request.getPhone());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userMapper.insertUser(user);

        return "User registered successfully";
    }

    public User login(LoginRequest request) {
        User user = userMapper.findByEmail(request.getEmail());
        if (user == null) return null;

        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }

    public User getUser(Long id) {
        return userMapper.findById(id);
    }
}
