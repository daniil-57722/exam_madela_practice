package com.dfilippov.practice.service;

import com.dfilippov.practice.dto.*;
import com.dfilippov.practice.entity.OfficeEntity;
import com.dfilippov.practice.entity.UserEntity;
import com.dfilippov.practice.exception.CustomException;
import com.dfilippov.practice.repository.CountryRepository;
import com.dfilippov.practice.repository.DocRepository;
import com.dfilippov.practice.repository.OfficeRepository;
import com.dfilippov.practice.repository.UserRepository;
import com.dfilippov.practice.specification.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    DocRepository docRepository;
    @Autowired
    OfficeRepository officeRepository;
    public ResponseEntity<String> registration(RegistrationRequest request) {
        if(userRepository.findByLogin(request.getLogin())!=null){
            return ResponseEntity.badRequest().body("данный логин уже используется");
        }
        else {
            byte[] array = new byte[16];
            new Random().nextBytes(array);
            String code = new String(array);
            System.out.println(request.getFirstname());
            UserEntity user = ObjectMapper.map(request, UserEntity.class);
            user.setCode(code);
            System.out.println(user.getFirstname());
            userRepository.save(user);
            return ResponseEntity.ok().body("Успех");
        }
    }

    public ResponseEntity<String> login(LoginRequest loginRequest) {
        UserEntity userEntity = userRepository.findByLoginAndPassword(loginRequest.getLogin(), loginRequest.getPassword());
        if(userEntity!=null){
            return ResponseEntity.ok().body("Здравствуйте, "+userEntity.getFirstname());
        } else {
            return ResponseEntity.badRequest().body("Неверный логин или пароль");
        }
    }

    public ResponseEntity<String> activate(String code) {
        UserEntity user = userRepository.findByCode(code);
        if(user!=null){
            user.setCode("1");
            userRepository.save(user);
            return ResponseEntity.ok().body("Успешно активирован");
        } else {
            return ResponseEntity.badRequest().body("Данный код не найден");
        }
    }

    public ResponseEntity<String> saveUser(UserAllArgsDto user) {
        UserEntity userEntity = ObjectMapper.map(user, UserEntity.class);
        userEntity.setCountry(countryRepository.findById(user.getCountryId()).orElse(null));
        userEntity.setDoc(docRepository.findById(user.getDocCode()).orElse(null));
        userEntity.setOffice(officeRepository.findById(user.getOfficeId()).orElse(null));
        System.out.println(userEntity.getCountry().getCountryName());
        System.out.println(userEntity.getDoc().getDocName());
        try{
            userRepository.save(userEntity);
            return ResponseEntity.ok("Пользователь успешно добавлен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    public ResponseEntity<String> updateUser(UserAllArgsDto user) {
        UserEntity userEntity = ObjectMapper.map(user, UserEntity.class);
        userEntity.setCountry(countryRepository.findById(user.getCountryId()).orElse(null));
        userEntity.setDoc(docRepository.findById(user.getDocCode()).orElse(null));
        userEntity.setOffice(officeRepository.findById(user.getOfficeId()).orElse(null));
        try{
            userRepository.save(userEntity);
            return ResponseEntity.ok("Пользователь успешно обновлен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Призошла ошибка");
        }
    }
    public UserAllArgsDto getUser(Long id) throws CustomException {
        UserEntity user = userRepository.findById(id).orElse(null);
        if(user == null){
            throw new CustomException("Не удалось найти пользователя");
        }
        return ObjectMapper.mapNested(user, UserAllArgsDto.class);
    }

    public List<UserListResponse> getUserList(UserListRequest request) {
        OfficeEntity office = officeRepository.findById(request.getOfficeId()).orElse(null);
        Specification<UserEntity> specification = UserSpecification.createSpecification(office, request.getFirstname(), request.getLastname(), request.getMiddlename(), request.getDocCode(), request.getCountryId());
        List<UserListResponse> result = ObjectMapper.mapAll(userRepository.findAll(specification), UserListResponse.class);
        return result;
    }
}
