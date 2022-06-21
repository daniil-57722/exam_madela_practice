package com.dfilippov.practice.repository;

import com.dfilippov.practice.entity.OfficeEntity;
import com.dfilippov.practice.entity.OrganizationEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfficeRepository extends CrudRepository<OfficeEntity, Long>, JpaRepository<OfficeEntity, Long>, JpaSpecificationExecutor<OfficeEntity> {
    List<OfficeEntity> findAll(Specification<OfficeEntity> specification);
}
