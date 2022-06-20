package com.dfilippov.practice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "office")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OfficeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long officeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "office")
    private List<UserEntity> users;
    private String name;
    private String address;
    private String phone;
    private Boolean active;
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private OrganizationEntity organization;
}
