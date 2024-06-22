package org.example.business.controller;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.util.IPAddress;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@RestController
public class DemoBusinessController {
    @GetMapping("/")
    public String demoBusiness() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            log.info("Server IP : {}", inetAddress.getHostAddress());
            return "Server IP: " + inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "Unable to get IP address";
        }
    }

}
