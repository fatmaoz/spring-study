package com.cybertek.services;

import com.cybertek.interfaces.Course;
import org.springframework.stereotype.Component;


//If your class name's second letter is also uppercase your default id
//will be with uppercase -->getBean("API")
@Component
public class API implements Course {

    @Override
    public void getTeachingHours() {

        System.out.println("It is coming from API class");

    }
}
