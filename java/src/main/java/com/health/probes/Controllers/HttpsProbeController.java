package com.health.probes.Controllers;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpsProbeController {
    Logger LOG = LoggerFactory.getLogger(HttpsProbeController.class);

    @GetMapping("/probe/https")
    public ResponseEntity<String> listAllHeaders(
            @RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> {
            LOG.info(String.format("Header '%s' = %s", key, value));
        });
        System.out.println("Receiving request from an HTTPS probe..");

        return new ResponseEntity<String>("HTTPS probe", HttpStatus.OK);
    }
}
