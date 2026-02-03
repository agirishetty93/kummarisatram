package com.kummari.controller;

import org.springframework.web.bind.annotation.*;

import com.kummari.dto.LoginRequest;
import com.kummari.dto.RegisterRequest;
import com.kummari.model.User;
import com.kummari.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest request) {
    	
    	System.out.println("welcome to API");
        return userService.register(request);
        		
    }

    @PostMapping("/login")
    public Object login(@Valid @RequestBody LoginRequest request) {
        User user = userService.login(request);
        return user != null ? user : "Invalid credentials";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
}