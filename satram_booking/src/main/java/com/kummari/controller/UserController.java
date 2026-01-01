package com.kummari.controller;

import com.kummari.dto.LoginRequest;
import com.kummari.dto.RegisterRequest;
import com.kummari.model.User;
import com.kummari.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public Object login(@RequestBody LoginRequest request) {
        User user = userService.login(request);
        if (user == null) {
            return "Invalid email or password";
        }
        return user; // returns full user object
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
}
