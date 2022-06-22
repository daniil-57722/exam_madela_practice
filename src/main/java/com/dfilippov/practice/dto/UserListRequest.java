package com.dfilippov.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserListRequest {
    private Long officeId;
    private String firstname;
    private String lastname;
    private String middlename;
    private Long docCode;
    private Long countryId;
}
