package week12.day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * [학습 예제 4] Week 12 Day 4 — JDBC 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 4] ResultSet 읽기
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - executeQuery(): SELECT → ResultSet 반환
 *  - rs.next(): 다음 행으로 이동 (없으면 false 반환)
 *  - rs.getString("컬럼명"), rs.getInt("컬럼명"): 값 읽기
 *
 * [문제별 학습 목표]
 * - 문제 4: ResultSet — rs.next() 반복으로 데이터 읽기
 */
public class Example4 {
    public static void main(String[] args) {
        String url  = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
        String user = "sa";
        String pass = "";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement()) {
            
            stmt.execute("CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY, name VARCHAR(50))");
            stmt.executeUpdate("INSERT INTO users VALUES (1, 'kim'), (2, 'lee')");

            try (ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {
                while (rs.next()) {
                    int id     = rs.getInt("id");
                    String name = rs.getString("name");
                    System.out.println("  id=" + id + ", name=" + name);
                }
            }
        } catch (Exception e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}
