package com.cybertek.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @OneToMany//field i list olmali :
    private List<Address> address;
}
