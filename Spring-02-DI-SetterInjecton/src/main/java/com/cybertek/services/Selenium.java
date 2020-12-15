package com.cybertek.services;

import com.cybertek.interfaces.Course;

public class Selenium implements Course {

    OfficeHours officeHours;
    @Override
    public void getTeachingHours() {

        System.out.println("java course teaching hours : " + (15 + officeHours.getHours()));

    }
}
