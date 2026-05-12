package week12.day4;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * [예습 파일] Week 12 Day 4 — JDBC 기초
 */
public class Preview {
    public static void main(String[] args) {
        System.out.println("JDBC는 자바와 DB를 연결해주는 표준 API입니다.");
        try {
            // 실제 드라이버와 URL이 있으면 연결됩니다.
            // Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("DB 연결 시도 (더미) -> ClassNotFoundException 예외 방지를 위해 주석 처리");
        } catch (Exception e) {
            System.out.println("드라이버 없음: " + e.getMessage());
        }
    }
}
