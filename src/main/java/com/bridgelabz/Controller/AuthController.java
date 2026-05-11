package com.bridgelabz.Controller;

import com.bridgelabz.DTO.*;
import com.bridgelabz.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        return authService.login(request);
    }

    @GetMapping("/google/success")
    public String googleLoginSuccess(
            @AuthenticationPrincipal OAuth2User user
    ) {

        return "Google Login Success : " + user.getAttribute("email");
    }
}