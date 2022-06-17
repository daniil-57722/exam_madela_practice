package com.dfilippov.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrganizationSaveRequest {
    private String name;
    private String fullname;
    private String inn;
    private String kpp;
    private String address;
    private String phone;
    private Boolean isActive;
}
