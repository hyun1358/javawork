package week11.day1;

public class Answer5 {
    public static void main(String[] args) {
        User admin = User.createAdmin("admin1234");
        System.out.println(admin.getRole());
    }

    static class User {
        private String id;
        private String pw;
        private String role;

        private User(String id, String pw, String role) {
            this.id = id;
            this.pw = pw;
            this.role = role;
        }

        public static User createAdmin(String pw) {
            return new User("admin", pw, "ADMIN_ROLE");
        }

        public String getRole() {
            return role;
        }
    }
}
