package com.kummari.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kummari.dto.LoginRequest;
import com.kummari.dto.RegisterRequest;
import com.kummari.model.User;
import com.kummari.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String register(RegisterRequest request) {
    	if (userRepository.findByEmail(request.getEmail()) != null) {
            return "Email already registered";
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(encoder.encode(request.getPassword()));

        userRepository.save(user);
        return "User registered successfully";
    }

    public User login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        if (user != null && encoder.matches(request.getPassword(), user.getPassword())) {
            return user;
        }
        return null;
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}