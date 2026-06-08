package week12.day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * [학습 예제 3] Week 12 Day 4 — JDBC 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 3] PreparedStatement
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  PreparedStatement (권장):
 *   - ? 플레이스홀더로 파라미터 분리
 *   - setString(1, input) 으로 값을 바인딩 → 자동 이스케이프
 *   - SQL Injection 완전 차단
 *
 * [문제별 학습 목표]
 * - 문제 3: PreparedStatement — SQL Injection 방지 방법
 */
public class Example3 {
    public static void main(String[] args) {
        String url  = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
        String user = "sa";
        String pass = "";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String safeSql = "SELECT * FROM users WHERE name = ?"; 
            try (PreparedStatement pstmt = conn.prepareStatement(safeSql)) {
                pstmt.setString(1, "kim"); 
                System.out.println("PreparedStatement 준비 완료: " + safeSql);
            }
        } catch (Exception e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}
