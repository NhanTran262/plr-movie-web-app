package com.app.plrmoviewebservice.controller;

import com.app.plrmoviewebservice.payload.ResponsePayload;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    @PostMapping("/register")
    public ResponseEntity<ResponsePayload> register() {
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity<ResponsePayload> login() {
        return null;
    }

    @PostMapping("/logout")
    public ResponseEntity<ResponsePayload> logout() {
        return null;
    }

}
