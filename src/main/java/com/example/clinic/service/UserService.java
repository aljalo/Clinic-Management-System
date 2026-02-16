package com.example.clinic.service;

import com.example.clinic.entity.User;

public interface UserService {

    User registerUser(String username, String password, String role);

    User findByUsername(String username);
}
