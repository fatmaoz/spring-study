import interfaces.Mentor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp {

    public static void main(String[] args) {

        //container i olusturduk
        BeanFactory container = new ClassPathXmlApplicationContext("config.xml");

        //bean i container dan istedik
        Mentor mentor =container.getBean("fullTimeMentor", Mentor.class);
        mentor.createAccount();

    }
}
