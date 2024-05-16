package com.example.learningSpring.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Shirali Alihummatov
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestRequest {

    private String name;
    private String surname;

}
