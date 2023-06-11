package designPattern.creationalPattern.builderPattern;

class User {

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    private final int id;
    private final String name;
    private final String email;
    private final String city;

    private User(UserBuilder userBuilder) {
        this.id = userBuilder.id;
        this.name = userBuilder.name;
        this.email = userBuilder.email;
        this.city = userBuilder.city;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    //inner class to create object
    static class UserBuilder {
        private int id;
        private String name;
        private String email;
        private String city;

        public UserBuilder() {

        }

        public UserBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public UserBuilder setName(String name) {
            this.name = name;
            return this;

        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public User build() {
            User user = new User(this);
            return user;
        }
    }

}

public class BuilderExample {
    public static void main(String[] args) {
        User user = new User.UserBuilder()
                .setId(123)
                .setCity("mumbai")
                .setName("satish")
                .build();

        System.out.println(user);
    }
}
