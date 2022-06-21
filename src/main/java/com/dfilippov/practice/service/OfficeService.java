package com.dfilippov.practice.service;

import com.dfilippov.practice.dto.*;
import com.dfilippov.practice.entity.OfficeEntity;
import com.dfilippov.practice.entity.OrganizationEntity;
import com.dfilippov.practice.exception.CustomException;
import com.dfilippov.practice.repository.OfficeRepository;
import com.dfilippov.practice.repository.OrganizationRepository;
import com.dfilippov.practice.specification.OfficeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeService {
    @Autowired
    OfficeRepository officeRepository;
    @Autowired
    OrganizationRepository organizationRepository;
    public ResponseEntity saveOffice(OfficeSaveRequest saveRequest) {
        try{
            OfficeEntity office = ObjectMapper.map(saveRequest, OfficeEntity.class);
            OrganizationEntity organization = organizationRepository.findById(saveRequest.getOrganizationId()).orElse(null);
            if(organization==null){
                return ResponseEntity.badRequest().body("Не удалось найти организацию");
            }
            office.setOrganization(organization);
            officeRepository.save(office);
            return ResponseEntity.ok("Офис успешно добавлен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Во время добавления произошла ошибка");
        }
    }

    public ResponseEntity updateOffice(OfficeAllArgsDto updateRequest) {
        try{
            OfficeEntity office = ObjectMapper.map(updateRequest, OfficeEntity.class);
            OrganizationEntity organization = organizationRepository.findById(updateRequest.getOrganizationId()).orElse(null);
            if(organization==null){
                return ResponseEntity.badRequest().body("Не удалось найти данную организацию");
            }
            office.setOrganization(organization);
            officeRepository.save(office);
            return ResponseEntity.ok("Оффис успешно обновлен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Во время добавления произошла ошибка");
        }
    }

    public ResponseEntity getOffice(Long id) {
        try{
            OfficeEntity office = officeRepository.findById(id).orElse(null);
            if(office == null){
                return ResponseEntity.badRequest().body("Не удалось найти данный офис");
            }
            return ResponseEntity.ok(ObjectMapper.map(office, OfficeFindByIdResponse.class));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    public List<OfficeListResponse> getOfficeList(Long orgId, OfficeListRequest officeListRequest) {
        try{
            OrganizationEntity organization = organizationRepository.findById(orgId).orElse(null);
            if(organization==null){
                throw new CustomException("Не удалось найти организацию");
            }
            List<OfficeEntity> offices = officeRepository.findAll(OfficeSpecification.createSpecification(orgId, officeListRequest.getName(), officeListRequest.getPhone(), officeListRequest.getActive()));
            List<OfficeListResponse> response = ObjectMapper.mapAll(offices, OfficeListResponse.class);
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
