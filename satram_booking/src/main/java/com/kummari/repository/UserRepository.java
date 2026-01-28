package com.kummari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kummari.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}