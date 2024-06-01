package com.example.learningSpring.model.dto.response;

import com.example.learningSpring.model.entity.IdCard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Shirali Alihummatov
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private LocalDateTime createdAt;
    private LocalDateTime lastLogin;
    private IdCard idCard;

}
