package com.capgemini.cma.service;

import com.capgemini.cma.domain.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
