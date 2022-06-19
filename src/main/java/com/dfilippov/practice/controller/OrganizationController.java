package com.dfilippov.practice.controller;

import com.dfilippov.practice.dto.OrganizationAllParamsDto;
import com.dfilippov.practice.dto.OrganizationListRequest;
import com.dfilippov.practice.dto.OrganizationSaveRequest;
import com.dfilippov.practice.entity.OrganizationEntity;
import com.dfilippov.practice.exception.CustomException;
import com.dfilippov.practice.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    OrganizationService organizationService;
    @PostMapping("/save")
    private ResponseEntity saveOrganization(@RequestBody OrganizationSaveRequest organizationSaveRequest){
        try{
            return ResponseEntity.ok(organizationService.save(organizationSaveRequest));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/update")
    private ResponseEntity updateOrganization(@RequestBody OrganizationAllParamsDto organization){
        try {
            return ResponseEntity.ok(organizationService.update(organization));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/list")
    private ResponseEntity organizationList(@RequestBody OrganizationListRequest organizationListRequest){
        try{
            return ResponseEntity.ok(organizationService.getFilteredList(organizationListRequest));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/{id}")
    private ResponseEntity organizationFind(@PathVariable Long id){
        try{
            return ResponseEntity.ok(organizationService.getOrganization(id));
        }catch (CustomException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}

