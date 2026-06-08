package week12.day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * [학습 예제 2] Week 12 Day 4 — JDBC 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 2] Statement
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  Statement:
 *   - SQL을 문자열로 그대로 실행
 *   - "SELECT * FROM users" 등 정적 쿼리에 사용
 *
 * [문제별 학습 목표]
 * - 문제 2: Statement — "SELECT * FROM users" 쿼리 실행
 */
public class Example2 {
    public static void main(String[] args) {
        String url  = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
        String user = "sa";
        String pass = "";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement()) {
            
            stmt.execute("CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY, name VARCHAR(50))");
            stmt.executeUpdate("INSERT INTO users VALUES (1, 'kim')");

            String sql = "SELECT * FROM users";
            System.out.println("실행 쿼리: " + sql);
            stmt.executeQuery(sql);
            System.out.println("쿼리 실행 완료");

        } catch (Exception e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}
