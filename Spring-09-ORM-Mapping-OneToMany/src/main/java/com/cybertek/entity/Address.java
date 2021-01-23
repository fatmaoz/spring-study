package com.cybertek.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {

    @Id
    private Long id;

    private String street;
    private String zipCode;

    @ManyToOne//bu bidirectioanl yapmak icinkullaniyoruz ama aslinda bidirectional olmuyor
    //iki farkli unidirectioanl yapiyoruz
    private Person person;
}
