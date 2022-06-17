package com.dfilippov.practice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "documents")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DocEntity {
    @Id
    private Long doc_id;
    private String doc_name;
    private String doc_code;
    private String doc_number;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
