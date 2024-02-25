package interviewBasics.builder;

public class Main {
    public static void main(String[] args) {
        User user = new User.UserBuilder().setId("123").setName("satish").setEmail("satish@gmail.com").build();

        System.out.println("Id : "+user.getId()+" \n"+"Name : "+user.getName()+"\n" + "email : "+user.getEmail());
    }
}
