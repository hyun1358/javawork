package week12.day4;

import java.sql.DriverManager;

public class Answer1 {
    public static void main(String[] args) {
        try {
            DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (Exception e) {
            System.out.println("드라이버 로드 실패 (정상)");
        }
    }
}
