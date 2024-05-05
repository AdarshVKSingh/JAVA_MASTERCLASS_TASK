package com.bezkoder.spring.files.excel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.files.excel.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
