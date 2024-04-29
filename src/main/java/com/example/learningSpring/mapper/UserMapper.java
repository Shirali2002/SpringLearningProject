package com.example.learningSpring.mapper;

import com.example.learningSpring.model.dto.request.RegisterRequest;
import com.example.learningSpring.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

/**
 * @author Shirali Alihummatov
 */

@Mapper(componentModel = "spring", imports = {LocalDateTime.class})
public interface UserMapper {

    @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
    User toUser(RegisterRequest registerRequest);

}
