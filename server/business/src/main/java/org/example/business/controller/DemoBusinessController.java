package org.example.business.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DemoBusinessController {
    @GetMapping("/")
    public String demoBusiness(){
        log.info("business Service~");
        return "Business Service!";
    }

}
