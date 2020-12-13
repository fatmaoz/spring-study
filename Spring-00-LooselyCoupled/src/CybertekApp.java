import services.FullTimeMentor;
import services.MentorAccount;

public class CybertekApp {

    public static void main(String[] args) {

        FullTimeMentor fullTimeMentor = new FullTimeMentor();

        MentorAccount mentorAccount = new MentorAccount(fullTimeMentor);

        mentorAccount.manageAccount();

    }
}
