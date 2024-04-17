package com.example.learningSpring.repository.mapper;

import com.example.learningSpring.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

/**
 * @author Shirali Alihummatov
 */

@Mapper
public interface UserMyBatisRepository {

    void insert(User user);
    Optional<User> findByUsername(@Param("username") String username);

}
