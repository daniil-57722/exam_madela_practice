package com.dfilippov.practice.controller;

import com.dfilippov.practice.dto.LoginRequest;
import com.dfilippov.practice.dto.RegistrationRequest;
import com.dfilippov.practice.entity.UserEntity;
import com.dfilippov.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/register")
    private ResponseEntity registration(@RequestBody RegistrationRequest registrationRequest){
        try{
            return ResponseEntity.ok(userService.registration(registrationRequest));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/login")
    private ResponseEntity login(@RequestBody LoginRequest loginRequest){
        try {
            return ResponseEntity.ok(userService.login(loginRequest));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/activate")
    private ResponseEntity activate(@RequestParam String code){
        try {
            return ResponseEntity.ok(userService.activate(code));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
