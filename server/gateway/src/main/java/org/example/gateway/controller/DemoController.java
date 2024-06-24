package org.example.gateway.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.gateway.config.EurekaClientConfig;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DemoController {

    private final RestTemplate restTemplate;
    private final EurekaClientConfig eurekaClientConfig;

    @GetMapping("/hello")
    public String hello(@RequestParam Long param) {
        log.info("hello");
        ResponseEntity<String> result = restTemplate.exchange("http://business/" +"userId="+ param,
                HttpMethod.GET, null, String.class);
        return result.toString();
    }
}
