package com.dfilippov.practice.repository;

import com.dfilippov.practice.entity.UserEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByFirstname(String firstname);
    UserEntity findByLogin(String login);
    UserEntity findByLoginAndPassword(String login, String pass);
    List<UserEntity> findAll(Specification<UserEntity> s);

    UserEntity findByCode(String code);

}
