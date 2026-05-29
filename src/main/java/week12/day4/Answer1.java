package week12.day4;

import java.sql.DriverManager;

// JDBC DriverManager를 사용하여 데이터베이스와 연결을 시도하는 예제입니다.
public class Answer1 {
    // 메인 메서드
    public static void main(String[] args) {
        try {
            // DriverManager를 통해 지정된 JDBC URL("jdbc:sqlite:test.db")로 DB 연결을 요청합니다.
            // SQLite 드라이버가 클래스패스에 존재한다면 test.db에 연결을 시도합니다.
            DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (Exception e) {
            // 드라이버가 없거나 연결에 실패한 경우 예외를 잡아 처리합니다. (테스트 환경이므로 정상 실패로 처리)
            System.out.println("드라이버 로드 실패 (정상)");
        }
    }
}
