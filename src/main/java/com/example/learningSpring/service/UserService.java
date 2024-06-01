package com.example.learningSpring.service;

import com.example.learningSpring.model.dto.request.LoginRequest;
import com.example.learningSpring.model.dto.request.RegisterRequest;
import com.example.learningSpring.model.dto.response.LoginResponse;
import com.example.learningSpring.model.dto.response.RegisterResponse;
import com.example.learningSpring.model.dto.response.UserResponse;
import com.example.learningSpring.model.entity.User;

import java.util.Optional;

/**
 * @author Shirali Alihummatov
 */
public interface UserService {

    LoginResponse login(LoginRequest loginRequest);
    RegisterResponse register(RegisterRequest registerRequest);

    Optional<User> getByUsername(String username);

    UserResponse getById(Long id);

}
