package com.dfilippov.practice.controller;

import com.dfilippov.practice.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocController {
    @Autowired
    DocService docService;
    @GetMapping("/docs")
    public ResponseEntity getDocs(){
        try{
            return ResponseEntity.ok(docService.getDocs());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
