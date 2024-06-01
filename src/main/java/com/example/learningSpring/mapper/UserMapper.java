package com.example.learningSpring.mapper;

import com.example.learningSpring.model.dto.request.RegisterRequest;
import com.example.learningSpring.model.dto.response.UserResponse;
import com.example.learningSpring.model.entity.User;
import com.example.learningSpring.model.entity.UserWrapper;
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

    @Mapping(target = "id", source = "usId")
    @Mapping(target = "name", source = "usName")
    @Mapping(target = "surname", source = "usSurname")
    @Mapping(target = "idCard.id", source = "idCardId")
    @Mapping(target = "idCard.name", source = "idCardName")
    @Mapping(target = "idCard.surname", source = "idCardSurname")
    @Mapping(target = "idCard.age", source = "age")
    @Mapping(target = "idCard.finCode", source = "finCode")
    @Mapping(target = "idCard.series", source = "series")
    @Mapping(target = "idCard.serialNumber", source = "serialNumber")
    UserResponse toUserResponse(UserWrapper userWrapper);

}
