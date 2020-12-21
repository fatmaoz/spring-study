package com.cybertek;

import com.cybertek.config.CybertekAppConfig;
import com.cybertek.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CybertekApp {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(CybertekAppConfig.class);

        Course course = context.getBean("java", Course.class);

        course.getTeachingHours();

        ((AnnotationConfigApplicationContext)context).close();
    }
}
