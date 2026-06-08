package week12.day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * [학습 예제 1] Week 12 Day 4 — JDBC 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 1] DriverManager.getConnection()
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - JDBC URL 형식: "jdbc:드라이버://호스트:포트/DB이름"
 *    예) "jdbc:mysql://localhost:3306/mydb"
 *        "jdbc:h2:mem:testdb" (인메모리 H2)
 *  - DriverManager.getConnection(url, user, password)
 *
 * [문제별 학습 목표]
 * - 문제 1: DriverManager.getConnection() — DB 연결
 */
public class Example1 {
    public static void main(String[] args) {
        String url  = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
        String user = "sa";
        String pass = "";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            System.out.println("DB 연결 성공! 드라이버: " + conn.getMetaData().getDriverName());
        } catch (SQLException e) {
            System.out.println("DB 오류: " + e.getMessage());
        }
    }
}
