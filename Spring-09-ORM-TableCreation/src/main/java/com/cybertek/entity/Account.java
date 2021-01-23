package com.cybertek.entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;


@MappedSuperclass//parent class i database tasirken kullanilir
public class Account {
    @Id
    private Long id;
    private String owner;
    private BigDecimal balance;

}
