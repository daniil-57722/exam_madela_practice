package com.dfilippov.practice.service;

import com.dfilippov.practice.dto.LoginRequest;
import com.dfilippov.practice.dto.RegistrationRequest;
import com.dfilippov.practice.entity.UserEntity;
import com.dfilippov.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
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
}
