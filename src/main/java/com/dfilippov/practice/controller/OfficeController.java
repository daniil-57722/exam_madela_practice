package com.dfilippov.practice.controller;

import com.dfilippov.practice.dto.OfficeListRequest;
import com.dfilippov.practice.dto.OfficeListResponse;
import com.dfilippov.practice.dto.OfficeSaveRequest;
import com.dfilippov.practice.dto.OfficeAllArgsDto;
import com.dfilippov.practice.entity.OfficeEntity;
import com.dfilippov.practice.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/office")
public class OfficeController {
    @Autowired
    OfficeService officeService;
    @PostMapping("/save")
    public ResponseEntity saveOffice(@RequestBody OfficeSaveRequest saveRequest){
        try{
            return officeService.saveOffice(saveRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/update")
    public ResponseEntity updateOffice(@RequestBody OfficeAllArgsDto updateRequest){
        try{
            return officeService.updateOffice(updateRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity getOfficeById(@PathVariable Long id){
        try{
            return officeService.getOffice(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/list/{id}")
    public ResponseEntity officeList(@PathVariable Long id,
                                               @RequestBody(required = false) OfficeListRequest officeListRequest){
        try{
            return ResponseEntity.ok(officeService.getOfficeList(id, officeListRequest));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
