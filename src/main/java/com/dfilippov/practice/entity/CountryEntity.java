package com.dfilippov.practice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CountryEntity {
    @Id
    private Long country_id;
    private String country_name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private List<UserEntity> users;
}
