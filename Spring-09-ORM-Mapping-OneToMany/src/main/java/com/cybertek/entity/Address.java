package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String zipCode;

    @ManyToOne
    private Person person;
    //mappedBy keyword u ile kullanamiyoruz
//    bu bidirectioanl yapmak icinkullaniyoruz ama aslinda bidirectional olmuyor
//    iki farkli unidirectioanl yapiyoruz



    public Address(String street, String zipCode) {
        this.street = street;
        this.zipCode = zipCode;
    }
}