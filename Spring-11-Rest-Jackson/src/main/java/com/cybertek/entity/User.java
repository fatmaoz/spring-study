package com.cybertek.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_account")
@JsonIgnoreProperties(value ={"hibernateLazyInitializer"},ignoreUnknown = true )
/*
value ={"hibernateLazyInitializer"}. Bunun eklenme sebebi:
eger class da fetch = FetchType.LAZY, varsa.Spring otomatik hibernateLazyInitializer field i ekliyor
bizde bunu ignore etmesi gerektigini belirmis oluyoruz deserilization yapma diyoruz'
User class i ticketing in icinde Lazy fetch yaptigimiz icin olustu.
 */
public class User extends BaseEntity{

    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//Bunu getter methodu kullanildiginda Json da gosterme
    //setter methodu kullanildiginda POST yaparken goster
    private String password;
    private String username;

    @OneToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "account_details_id")
    @JsonManagedReference//
    private Account account;

    public User(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }
}
