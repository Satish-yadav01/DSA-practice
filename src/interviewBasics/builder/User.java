package interviewBasics.builder;

public class User {
    private final String id;
    private final String name;
    private final String email;

    private User(UserBuilder userBuilder) {
        this.id = userBuilder.id;
        this.name = userBuilder.name;
        this.email = userBuilder.email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    //inner class to create object
    static class UserBuilder{
        private String id;
        private String name;
        private String email;

        public UserBuilder(){

        }

        public UserBuilder setId(String id) {
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

        public User build(){
            User user = new User(this);
            return user;
        }
    }
}
