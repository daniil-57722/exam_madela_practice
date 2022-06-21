package com.dfilippov.practice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String firstname;
    private String lastname;
    private String middlename;//прикольное название придумали. это типо отчество? даже если нет то уже поздно =P
    private String phone;
    private String login;
    private String password;
    private String code;
    private String docNumber;
    private String docDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doc_code")
    private DocEntity doc;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private CountryEntity country;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "office_id")
    private OfficeEntity office;
}
