package com.dfilippov.practice.repository;

import com.dfilippov.practice.entity.OrganizationEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrganizationRepository extends CrudRepository<OrganizationEntity, Long>, JpaRepository<OrganizationEntity, Long>, JpaSpecificationExecutor<OrganizationEntity> {
    OrganizationEntity findByInnAndKppAndPhone(String inn, String kpp, String phone);
    List<OrganizationEntity> findAll(Specification<OrganizationEntity> s);
}
