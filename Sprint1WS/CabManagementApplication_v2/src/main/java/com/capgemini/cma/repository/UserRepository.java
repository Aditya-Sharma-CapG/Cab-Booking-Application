package com.capgemini.cma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.cma.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
