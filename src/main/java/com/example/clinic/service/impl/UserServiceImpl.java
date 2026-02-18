package com.example.clinic.service.impl;

import com.example.clinic.entity.Role;
import com.example.clinic.entity.User;
import com.example.clinic.exception.DuplicateUserException;
import com.example.clinic.exception.UserNotFoundException;
import com.example.clinic.repository.UserRepository;

import com.example.clinic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(String username, String password, String role){
        if (userRepository.findByUsername(username).isPresent()){
            throw new DuplicateUserException("Username already exists");
        }

        Role userRole = Role.valueOf(role.toUpperCase());

        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .role(userRole)
                .build();
        return userRepository.save(user);
    }
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("Username not found"));
    }
}
