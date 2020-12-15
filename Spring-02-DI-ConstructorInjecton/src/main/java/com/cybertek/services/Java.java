package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;

public class Java implements Course {

    //eger Officehours olursa baska bisey icin ihtiyac oldugunda burdan degistirmem gerekiyor ama
    //ExtraSession interface kullanirsa config.xml de ne yazdiysak ref e implemented i kullanir. Looselycoupled

    //OfficeHours officeHours;

    ExtraSessions extraSessions;

    public Java(ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }

    @Override
    public void getTeachingHours() {

        System.out.println("java course teaching hours : " + (20 + extraSessions.getHours()));

    }
}
