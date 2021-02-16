package com.cybertek.entity;

import com.cybertek.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "account_details")
@ToString
@JsonIgnoreProperties(value = {"state","postalCode"},ignoreUnknown = true)//bu annotation ile tek satirda
//Liste seklinde Json da gozukmesini istemediginiz seyleri yazabilirsiniz
/*
ignoreUnknown = true security icin konuluyor
eger sana gelen class fieldinin value'su DB dekiyle eslesmiyorsa
serilization/deserilization yapma demek
 */
public class Account extends BaseEntity{

    //@JsonIgnore//Json da name i gosterme demek. Bu tek bir field icin
    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;
    @Column(name = "postal_code")
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.ADMIN;

    @OneToOne(mappedBy = "account")
    @JsonBackReference//Bu annotation user in bilgilerini de API da gostermemeyi sagliyor.
    // User class da da mapping in oldugu field da  @JsonManagedReference eklemek gerekiyor//
    //Normalde JsonIgnore da bu isi yapiyor ama Developerlar table lar arasi relation i gormek istiyor
    private User user;

    public Account(String name, String address, String country,
                   String state, String city, Integer age, String postalCode, UserRole role) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.state = state;
        this.city = city;
        this.age = age;
        this.postalCode = postalCode;
        this.role = role;
    }
}

