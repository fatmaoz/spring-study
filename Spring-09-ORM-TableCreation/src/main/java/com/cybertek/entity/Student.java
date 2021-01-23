package com.cybertek.entity;

import com.cybertek.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "students")//it changes the table name
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//Bu olunca bizim identity olusturmamiza gerek kalmiyor
    //otomatik hibernate uretiyor.apllication properties den id leri silebiliriz
    private Long id;

    @Column(name = "studentFirstName")//it changes column name
    private String firstName; //in database first_name
    @Column(name = "studentLastName")
    private String lastName;
    @Column(name = "studentEmailAddres")
    private String email;
    
    @Transient//bu annotation field in database e gitmemesini sagliyor non persistent yapiyor
    private String city;
    //Java 8 den once Date kullanilirken databe e mapping de hata oluyordu o yuzden @Tempoaral koyup type i belirtmek gerekiyor
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Temporal(TemporalType.TIME)
    private Date birthTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birtDateTime;

    //Java 8 ve sonrasi LocalDate ile @Temporal koymadan mapping oluyor ama MVC de sikinti olabilecegi icin @Column ekliyoruz
    @Column(columnDefinition = "DATE")
    private LocalDate localDate;
    @Column(columnDefinition = "TIME")
    private LocalTime localTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime localDateTime;

    //Eger enum varsa string e cevirmek icin @Enumerated annotation i koymak zorundasin ve type i String/original sacebilirsin
    @Enumerated(EnumType.STRING)
    private Gender gender;


}
