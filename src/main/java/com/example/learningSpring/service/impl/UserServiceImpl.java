package com.example.learningSpring.service.impl;

import com.example.learningSpring.mapper.UserMapper;
import com.example.learningSpring.model.dto.request.LoginRequest;
import com.example.learningSpring.model.dto.request.RegisterRequest;
import com.example.learningSpring.model.dto.response.LoginResponse;
import com.example.learningSpring.model.dto.response.RegisterResponse;
import com.example.learningSpring.model.entity.User;
import com.example.learningSpring.repository.mapper.UserMyBatisRepository;
import com.example.learningSpring.service.UserService;
import com.example.learningSpring.util.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Shirali Alihummatov
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMyBatisRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        authenticationManager.authenticate(authenticationToken);
        Optional<User> userOptional = getByUsername(loginRequest.getUsername());

        if (userOptional.isEmpty()) {
            return LoginResponse.withResponse("user is not exist.");
        }

        String token = jwtProvider.generateToken(userOptional.get());

        return LoginResponse.withToken(token);
    }

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
//        registerRequest.getPassword().equals(registerRequest.getConfirmPassword())
//        null.equals(registerRequest.getConfirmPassword()) ---> NullPointerException

        if (!Objects.equals(registerRequest.getPassword(), registerRequest.getConfirmPassword())) {
            return new RegisterResponse("passwords_not_matched");
        }

        Optional<User> byUsernameOptional = userRepository.findByUsername(registerRequest.getUsername());

        if (byUsernameOptional.isPresent()) {
            return new RegisterResponse("duplicate_username");
        }

        User user = userMapper.toUser(registerRequest);
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        userRepository.insert(user);
        return new RegisterResponse("success");
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
