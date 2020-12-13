package services;

import interfaces.Mentor;

public class FullTimeMentor implements Mentor {

    @Override
    public void createAccount() {

        System.out.println("FullTime Mentor is created");
    }
}
