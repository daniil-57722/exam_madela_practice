package com.dfilippov.practice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "organization")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrganizationEntity {
    @Id
    @Column(name = "organization_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String fullname;
    private String inn;
    private String kpp;
    private String address;
    private String phone;
    private Boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
    private List<OfficeEntity> offices;
}
