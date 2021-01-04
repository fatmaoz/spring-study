package com.cybertek.model;


import lombok.*;
@ToString
public class Employee {

    private String firstName;
    private String lastName;
    private String birthday;
    private String email;
    private String password;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;

    public Employee(String firstName, String lastName, String birthday, String email, String password, String address, String address2, String city, String state, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.address = address;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Employee() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
