package com.health.probes.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpProbeController {
    String msg = "";

    @GetMapping("/probe/http")
    public String httpProbe() {

    }
}
