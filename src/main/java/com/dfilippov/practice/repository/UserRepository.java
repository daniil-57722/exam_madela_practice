package com.dfilippov.practice.repository;

import com.dfilippov.practice.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByFirstname(String firstname);
    UserEntity findByLogin(String login);
    UserEntity findByLoginAndPassword(String login, String pass);

    UserEntity findByCode(String code);

}
