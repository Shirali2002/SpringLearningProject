package com.example.learningSpring.model.entity;

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
public class UserWrapper {

    //user fields
    private Long usId;
    private String usName;
    private String usSurname;
    private String username;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime lastLogin;

    //id card fields
    private Long idCardId;
    private String idCardName;
    private String idCardSurname;
    private Integer age;
    private String finCode;
    private String series;
    private String serialNumber;

}
