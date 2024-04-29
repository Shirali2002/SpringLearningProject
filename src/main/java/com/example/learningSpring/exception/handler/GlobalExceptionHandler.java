package com.example.learningSpring.exception.handler;

import com.example.learningSpring.exception.CommonException;
import com.example.learningSpring.exception.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Shirali Alihummatov
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<ErrorDetails> handleUserNotExistException(CommonException exception) {
        ErrorDetails errorDetails = new ErrorDetails(exception.getCode(), exception.getDescription());
        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(errorDetails);
    }

//    @ExceptionHandler(UserNotExistException.class)
//    public ResponseEntity<ErrorDetails> handleUserNotExistException(UserNotExistException exception) {
//        ErrorDetails errorDetails = new ErrorDetails("1000", "user not exist in db");
//        return ResponseEntity
//                .status(HttpStatus.BAD_REQUEST)
//                .body(errorDetails);
//    }
//
//    @ExceptionHandler(PasswordsNotMatchedException.class)
//    public ResponseEntity<ErrorDetails> handlePasswordsNotMatchedException(PasswordsNotMatchedException exception) {
//        ErrorDetails errorDetails = new ErrorDetails("1001", "password and confirmPassword not matched");
//        return ResponseEntity
//                .status(HttpStatus.BAD_REQUEST)
//                .body(errorDetails);
//    }

}
