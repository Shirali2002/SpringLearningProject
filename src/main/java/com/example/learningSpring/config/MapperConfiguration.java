package com.example.learningSpring.config;

import com.example.learningSpring.mapper.IdCardMapper;
import com.example.learningSpring.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Shirali Alihummatov
 */
@Configuration
public class MapperConfiguration {

    @Bean
    public IdCardMapper idCardMapper() {
        return IdCardMapper.INSTANCE;
    }

    @Bean
    public UserMapper userMapper() {
        return UserMapper.INSTANCE;
    }

}
