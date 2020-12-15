import com.cybertek.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp {

    public static void main(String[] args) {

        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        Course course = container.getBean("java",Course.class);


        course.getTeachingHours();
        /*course object in sadece methodu degil field ini da almak istiyorsak
            casting yapmaliyiz ve o field farkli package de oldugumuz icin public olmali
             ya da
             ona ait getter setter olmali
         */

    }
}
