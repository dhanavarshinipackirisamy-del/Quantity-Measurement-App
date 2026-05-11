package com.bridgelabz.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoogleAuthController {

    @GetMapping("/google-success")
    public String googleSuccess() {
        return "Google Login Success";
    }
}