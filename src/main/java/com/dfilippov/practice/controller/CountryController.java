package com.dfilippov.practice.controller;

import com.dfilippov.practice.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CountryController {
    @Autowired
    CountryService countryService;
    @GetMapping("/countries")
    private ResponseEntity getCountries(){
        try{
            return ResponseEntity.ok(countryService.getCountries());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
