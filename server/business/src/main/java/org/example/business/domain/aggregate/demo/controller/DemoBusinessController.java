package org.example.business.domain.aggregate.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.util.IPAddress;
import org.example.business.domain.aggregate.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DemoBusinessController {

    private final UserService userService;
    @GetMapping("/")
    public String demoBusiness(@RequestParam Long userId) {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            log.info("Server IP : {}", inetAddress.getHostAddress());
            String userName = userService.getUserName(userId);
            return "Server IP: " + inetAddress.getHostAddress() + " " + userName;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "Unable to get IP address";
        }
    }

}
