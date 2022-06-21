package com.dfilippov.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OfficeFindByIdResponse {
    private Long officeId;
    private String name;
    private String address;
    private String phone;
    private Boolean active;
}
