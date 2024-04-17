package com.example.learningSpring.service.impl;

import com.example.learningSpring.mapper.UserMapper;
import com.example.learningSpring.model.dto.request.RegisterRequest;
import com.example.learningSpring.model.dto.response.RegisterResponse;
import com.example.learningSpring.model.entity.User;
import com.example.learningSpring.repository.mapper.UserMyBatisRepository;
import com.example.learningSpring.service.UserService;
import lombok.RequiredArgsConstructor;
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
    private final UserMapper userMapper;

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

        userRepository.insert(user);
        return new RegisterResponse("success");
    }

}
