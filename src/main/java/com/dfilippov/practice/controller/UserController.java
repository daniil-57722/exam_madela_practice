package com.dfilippov.practice.controller;

import com.dfilippov.practice.dto.LoginRequest;
import com.dfilippov.practice.dto.RegistrationRequest;
import com.dfilippov.practice.dto.UserAllArgsDto;
import com.dfilippov.practice.dto.UserListRequest;
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
    @PostMapping("/user/save")
    private ResponseEntity saveUser(@RequestBody UserAllArgsDto user){
        try{
            return ResponseEntity.ok(userService.saveUser(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/user/update")
    private ResponseEntity updateUser(@RequestBody UserAllArgsDto user){
        try{
            return ResponseEntity.ok(userService.updateUser(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/user/{id}")
    private ResponseEntity getUser(@PathVariable Long id){
        try{
            return ResponseEntity.ok(userService.getUser(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/user/list")
    private ResponseEntity getUserList(@RequestBody UserListRequest request){
        try{
            return ResponseEntity.ok(userService.getUserList(request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
