package com.example.learningSpring.controller;

import com.example.learningSpring.model.dto.request.TestRequest;
import com.example.learningSpring.model.dto.response.TestResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author Shirali Alihummatov
 */

@Slf4j
@RestController
@RequestMapping("test")
@RequiredArgsConstructor
public class TestController {

    private final WebClient webClient;

    @GetMapping("web-flux")
    public ResponseEntity<TestResponse> testWebFlux(@RequestParam Integer code) {
        log.info("calling test api");
        TestResponse testResponse = webClient
                .get()
                .uri("http://localhost:5000",
                        uriBuilder -> uriBuilder
                                .path("/api/test")
                                .queryParam("code", code)
                                .build())
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        clientResponse -> clientResponse
                                .bodyToMono(TestResponse.class)
                                .flatMap(resp ->
                                        Mono.error(
                                                new RuntimeException("code is " + resp.getCode())
                                        )))
                .bodyToMono(TestResponse.class)
                .block();

        log.info("api called. response: {}", testResponse);

        return ResponseEntity.ok(testResponse);
    }

    @PostMapping("web-flux-post")
    public ResponseEntity<List<TestResponse>> testWebFluxPost(@RequestBody TestRequest testRequest, @RequestHeader String fatherName) {
        log.info("calling test post api. testRequest: {}, header: {}", testRequest, fatherName);

        List<TestResponse> testResponse = webClient.post()
                .uri("http://localhost:5000",
                        uriBuilder -> uriBuilder
                                .path("/api/test-post")
                                .build())
                .body(Mono.just(testRequest), TestRequest.class)
                .header("fatherName", fatherName)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<TestResponse>>() {
                })
                .block();


        log.info("api called. response: {}", testResponse);

        return ResponseEntity.ok(testResponse);
    }

}
