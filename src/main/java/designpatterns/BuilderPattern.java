package designpatterns;

public class User {
    private String name;
    private String email;

    private User(){
    }

    public static class Builder {
        private final User user;

        public Builder() {
            this.user = new User();
        }

        public Builder withName(String name) {
            this.user.setName(name);
            return this;
        }

        public Builder withEmail(String email) {
            this.user.setEmail(email);
            return this;
        }

        public User build() {
            return this.user;
        }
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public static void main(String[] args) {
        User user = new User.Builder()
                .withName("John")
                .withEmail("a@mail.com")
                .build();

        System.out.println(user.getEmail());
        System.out.println(user.getName());
    }

}

