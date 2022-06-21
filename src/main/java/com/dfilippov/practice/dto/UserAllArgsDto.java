package com.dfilippov.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserAllArgsDto {
    private Long userId;
    private String firstname;
    private String lastname;
    private String middlename;
    private String phone;
    private Long docCode;
    private String docNumber;
    private String docName;
    private String docDate;
    private Long countryCode;
    private String login;
    private String password;
    private Long office;
}
