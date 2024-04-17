package com.example.learningSpring.service;

import com.example.learningSpring.model.dto.request.RegisterRequest;
import com.example.learningSpring.model.dto.response.RegisterResponse;

/**
 * @author Shirali Alihummatov
 */
public interface UserService {

    RegisterResponse register(RegisterRequest registerRequest);

}
