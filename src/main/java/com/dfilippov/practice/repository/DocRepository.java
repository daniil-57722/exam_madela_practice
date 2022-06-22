package com.dfilippov.practice.repository;

import com.dfilippov.practice.entity.DocEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DocRepository extends CrudRepository<DocEntity, Long> {
    List<DocEntity> findAll();
}
