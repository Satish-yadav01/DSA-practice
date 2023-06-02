package designPattern;

interface EmailService{
    void sendMail(String to,String from, String body);
}

class EmailServiceImpl implements EmailService{

    @Override
    public void sendMail(String to, String from, String body) {
        System.out.println("to : " + to);
        System.out.println("from : " + from);
        System.out.println("body : " + body);
    }
}

class UserService{
    private final EmailService emailService;

    UserService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void registerUser(String email,String name){
        System.out.println("registration successfully!! with " + name + "and with email : " + email);
        String subject = "Welcome to our application";
        String body = "Dear " + name + ", welcome to our application!";
        emailService.sendMail(email,subject,body);
    }
}

public class looseCoupleingExample {
    public static void main(String[] args) {

        UserService userService = new UserService(new EmailServiceImpl());
        userService.registerUser("abc@gmail.com","satish");
    }


}
