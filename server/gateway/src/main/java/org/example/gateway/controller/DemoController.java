package org.example.gateway.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DemoController {

    private final RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello() {
        log.info("hello");
        ResponseEntity<String> result = restTemplate.exchange("http://business/",
                HttpMethod.GET, null, String.class);
        return result.toString();
    }
}
