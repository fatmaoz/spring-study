package com.cybertek.configs;

import com.cybertek.interfaces.ExtraSessions;
import com.cybertek.services.Java;
import com.cybertek.services.OfficeHours;
import com.cybertek.services.Selenium;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;

@Configuration
@ComponentScan("com.cybertek")
@PropertySource("classpath:application.properties")
public class CybertekAppConfig {

    @Bean
    public Java java(){

        return new Java(extraSessions());

    }

    @Bean
    public Selenium selenium(){

        return new Selenium();

    }

    @Bean
    public OfficeHours officeHours(){

        return new OfficeHours();

    }
    //more loosly coupled way:
    @Bean //You don have to write @Bean annotation if this method is for injected object
    public ExtraSessions extraSessions(){

        return new OfficeHours();
    }


}
