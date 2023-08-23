package com.health.probes.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    String message = "container-apps-health-probe-examples-java";

    @GetMapping("/")
    public String index() {
        return message;
    }
}