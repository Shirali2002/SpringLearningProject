package com.example.learningSpring.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatusCode;

/**
 * @author Shirali Alihummatov
 */
@Getter
@AllArgsConstructor
public class CommonException extends RuntimeException {

    private String code;
    private String description;
    private HttpStatusCode httpStatus;

}
