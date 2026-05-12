package week05.day5;

public class Answer3 {
    public static void main(String[] args) {
        System.out.println("최대 유저: " + AppConfig.MAX_USERS);
    }
}

class AppConfig {
    static final int MAX_USERS = 1000;
    static final String VERSION = "1.0.0";
}
