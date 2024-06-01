package com.example.learningSpring.controller;

import com.example.learningSpring.exception.ErrorDetails;
import com.example.learningSpring.model.dto.request.LoginRequest;
import com.example.learningSpring.model.dto.request.RegisterRequest;
import com.example.learningSpring.model.dto.response.LoginResponse;
import com.example.learningSpring.model.dto.response.RegisterResponse;
import com.example.learningSpring.model.dto.response.UserResponse;
import com.example.learningSpring.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shirali Alihummatov
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) {
        RegisterResponse registerResponse = userService.register(registerRequest);
        return ResponseEntity.ok(registerResponse);
    }

    @Operation(description = "for login and get token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "400", description = "bad request with detail",
                    content = @Content(
                            schema = @Schema(implementation = ErrorDetails.class),
                            examples = {
                                    @ExampleObject(name = "User not exist", value = "{\n  \"code\": \"1000\",\n  \"description\": \"user not exist in db\"\n}"),
                                    @ExampleObject(name = "Wrong password", value = "{\n  \"code\": \"1005\",\n  \"description\": \"wrong password\"\n}"),
                            }
                    )),
            @ApiResponse(responseCode = "500", description = "internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorDetails.class),
                            examples = @ExampleObject(name = "Internal Server Error", value = "{\n  \"code\": \"5500\",\n  \"description\": \"exception message\"\n}")
                    ))
    }
    )
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = userService.login(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
        UserResponse user = userService.getById(id);
        log.info("controller user: {}", user);
        return ResponseEntity.ok(user);
    }

}
