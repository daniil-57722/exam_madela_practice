package com.dfilippov.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfficeListResponse {
    private Long officeId;
    private String name;
    private Boolean active;
}
