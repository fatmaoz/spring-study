package cybertek.services;

import cybertek.interfaces.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Selenium implements Course {

    //Filed injection icin:
    //@Autowired
    //OfficeHours officeHours;
/*
    @Autowired
    public void setOfficeHours(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }
*/

    @Override
    public void getTeachingHours() {

    }
}
