package com.dfilippov.practice.controller;

import com.dfilippov.practice.dto.OfficeSaveRequest;
import com.dfilippov.practice.dto.OfficeUpdateRequest;
import com.dfilippov.practice.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity updateOffice(@RequestBody OfficeUpdateRequest updateRequest){
        try{
            return officeService.updateOffice(updateRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
