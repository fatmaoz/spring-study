package com.cybertek;

import com.cybertek.inrerfaces.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring07SpringBootDemoApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Spring07SpringBootDemoApplication.class, args);

        Course course = context.getBean("java",Course.class);
        System.out.println(course.getTeachingHours());
    }

}
