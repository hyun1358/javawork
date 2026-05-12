package week05.day5;

public class Answer5 {
    public static void main(String[] args) {
        User user = new User("guest", "1234");
        System.out.println(user.getId());
    }
}

class User {
    private final String id; // ID는 변경 불가
    private String pw;
    public static final String SITE_NAME = "MySite";

    public User(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
