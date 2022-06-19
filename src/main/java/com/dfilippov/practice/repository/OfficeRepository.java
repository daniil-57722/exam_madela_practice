package com.dfilippov.practice.repository;

import com.dfilippov.practice.entity.OfficeEntity;
import org.springframework.data.repository.CrudRepository;

public interface OfficeRepository extends CrudRepository<OfficeEntity, Long> {
}
