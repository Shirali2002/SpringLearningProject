package com.example.learningSpring.model.dto.request;

import lombok.Data;

/**
 * @author Shirali Alihummatov
 */

@Data
public class RegisterRequest {

    private String username;
    private String password;
    private String confirmPassword;
    private String name;
    private String surname;

}
