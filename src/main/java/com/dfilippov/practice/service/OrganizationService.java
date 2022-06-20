package com.dfilippov.practice.service;

import com.dfilippov.practice.dto.OrganizationAllParamsDto;
import com.dfilippov.practice.dto.OrganizationListRequest;
import com.dfilippov.practice.dto.OrganizationListResponse;
import com.dfilippov.practice.dto.OrganizationSaveRequest;
import com.dfilippov.practice.entity.OrganizationEntity;
import com.dfilippov.practice.exception.CustomException;
import com.dfilippov.practice.repository.OrganizationRepository;
import com.dfilippov.practice.specification.OrganizationSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {
    @Autowired
    OrganizationRepository organizationRepository;
    public ResponseEntity<String> save(OrganizationSaveRequest organizationSaveRequest){
        if(organizationRepository.findByInnAndKppAndPhone(organizationSaveRequest.getInn(),
                organizationSaveRequest.getKpp(), organizationSaveRequest.getPhone())!=null){
            throw new RuntimeException();
        } else {
            OrganizationEntity organization = ObjectMapper.map(organizationSaveRequest, OrganizationEntity.class);
            organizationRepository.save(organization);
            return ResponseEntity.ok("успешно");
        }
    }
    public ResponseEntity<String> update(OrganizationAllParamsDto organization) {
        OrganizationEntity oldOrganization = organizationRepository.findById(organization.getId()).get();
        if(oldOrganization != null){
            oldOrganization = ObjectMapper.map(organization, OrganizationEntity.class);
            organizationRepository.save(oldOrganization);
            return ResponseEntity.ok("изменения внесены");
        } else {
            return ResponseEntity.badRequest().body("не удалось найти данную организацию");
        }
    }
    public List<OrganizationListResponse> getFilteredList(OrganizationListRequest organizationListRequest) {
        Specification<OrganizationEntity> spec= OrganizationSpecification.createSpecification(organizationListRequest.getName(), organizationListRequest.getInn(), organizationListRequest.getIsActive());
        List<OrganizationEntity> organizations = organizationRepository.findAll(spec);
        return ObjectMapper.mapAll(organizations, OrganizationListResponse.class);
    }

    public OrganizationAllParamsDto getOrganization(Long id) throws CustomException {
        OrganizationAllParamsDto organization = ObjectMapper.map(organizationRepository.findById(id), OrganizationAllParamsDto.class);
        if(organization==null){
            throw new CustomException("Не удалось найти данную организацию");
        }
        return organization;
    }
}
