package com.dfilippov.practice.repository;

import com.dfilippov.practice.entity.CountryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<CountryEntity, Long> {
    List<CountryEntity> findAll();
}
