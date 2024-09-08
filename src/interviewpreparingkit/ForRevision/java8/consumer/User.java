package interviewpreparingkit.ForRevision.java8.consumer;

import java.util.List;
import java.util.function.Consumer;

public class User {
    private int id;
    private String name;
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class UserExample{

    public static Consumer<User> sendNotification = user -> {
        System.out.println("sending notification by "+user.getName());
    };

    public static Consumer<User> logUser = user ->{
        System.out.println("Logging user: " + user.getName());
    };


    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1, "satish"),
                new User(2, "abhi"),
                new User(3, "naman")
        );

        users.forEach(logUser.andThen(sendNotification));
    }
}
