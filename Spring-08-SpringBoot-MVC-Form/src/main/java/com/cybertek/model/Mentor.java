package com.cybertek.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class Mentor {

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private boolean graduated;
    private String batch;
    private String company;

    public Mentor() {
    }

    public Mentor(String firstName, String lastName, String email, String gender, boolean graduated, String batch, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.graduated = graduated;
        this.batch = batch;
        this.company = company;
    }
}
