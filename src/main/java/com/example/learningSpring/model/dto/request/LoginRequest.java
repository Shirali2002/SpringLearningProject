package com.example.learningSpring.model.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author Shirali Alihummatov
 */
@Data
public class LoginRequest {

    private String username;
    private String password;

}
