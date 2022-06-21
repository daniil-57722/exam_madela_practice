package com.dfilippov.practice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "documents")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DocEntity {
    @Id
    private Long doc_code;
    private String doc_name;
    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "doc")
    private List<UserEntity> users;
}
