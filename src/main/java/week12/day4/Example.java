package week12.day4;

import java.sql.*;

/**
 * [학습 예제] Week 12 Day 4 — JDBC 완전 정복
 *
 * ★ 이 파일은 오늘 풀어야 할 연습 문제 5개의 핵심 기술을 모두 담고 있습니다.
 *
 * [문제별 학습 목표]
 * - 문제 1: DriverManager.getConnection() — DB 연결
 * - 문제 2: Statement — "SELECT * FROM users" 쿼리 실행
 * - 문제 3: PreparedStatement — SQL Injection 방지 방법
 * - 문제 4: ResultSet — rs.next() 반복으로 데이터 읽기
 * - 문제 5: try-with-resources — 자원 자동 반납
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 1] DriverManager.getConnection()
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - JDBC URL 형식: "jdbc:드라이버://호스트:포트/DB이름"
 *    예) "jdbc:mysql://localhost:3306/mydb"
 *        "jdbc:h2:mem:testdb" (인메모리 H2)
 *        "jdbc:sqlite:test.db" (SQLite)
 *  - DriverManager.getConnection(url, user, password)
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 2] Statement vs PreparedStatement
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  Statement:
 *   - SQL을 문자열로 그대로 실행
 *   - 문자열 연결로 SQL Injection 취약점 발생 가능
 *   - 예: "SELECT * FROM users WHERE name = '" + input + "'"
 *         input = "'; DROP TABLE users; --" → SQL Injection!
 *
 *  PreparedStatement (권장):
 *   - ? 플레이스홀더로 파라미터 분리
 *   - setString(1, input) 으로 값을 바인딩 → 자동 이스케이프
 *   - SQL Injection 완전 차단
 *   - 동일 쿼리 반복 시 컴파일 캐싱 → 성능도 우수
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 4] ResultSet 읽기
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - executeQuery(): SELECT → ResultSet 반환
 *  - executeUpdate(): INSERT/UPDATE/DELETE → 영향받은 행 수 반환
 *  - rs.next(): 다음 행으로 이동 (없으면 false 반환)
 *  - rs.getString("컬럼명"), rs.getInt("컬럼명"): 값 읽기
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 5] try-with-resources (자원 자동 반납)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - JDBC 객체들은 AutoCloseable 구현 → try-with-resources 사용 가능
 *  - 블록이 끝나면 ResultSet → PreparedStatement → Connection 순으로 자동 close()
 *  - 예외 발생 시에도 반드시 close() 보장 → DB 연결 누수 방지
 */
public class Example {
    public static void main(String[] args) {

        // ─────────────────────────────────────────────
        // JDBC 4단계 흐름 구조 (→ 문제 1~5 전체 참고)
        // ─────────────────────────────────────────────
        System.out.println("=== JDBC 4단계 흐름 ===");
        System.out.println("1단계: Connection 얻기  (DriverManager.getConnection)");
        System.out.println("2단계: SQL 준비         (Statement 또는 PreparedStatement)");
        System.out.println("3단계: SQL 실행         (executeQuery 또는 executeUpdate)");
        System.out.println("4단계: 결과 처리 & 자원 반납 (ResultSet → close)");

        // ─────────────────────────────────────────────
        // Lab 1: Connection 구조 (→ 문제 1 참고)
        // H2 인메모리 DB를 사용한 실제 연결 예시
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 1: JDBC Connection + 테이블 생성 ===");
        // JDBC URL: jdbc:h2:mem:testdb — 인메모리 H2 DB
        // 실제 MySQL이라면: "jdbc:mysql://localhost:3306/mydb"
        String url  = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
        String user = "sa";
        String pass = "";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            System.out.println("DB 연결 성공! 드라이버: " + conn.getMetaData().getDriverName());

            // ─────────────────────────────────────────────
            // Lab 2: Statement — 테이블 생성 + 조회 (→ 문제 2 참고)
            // ─────────────────────────────────────────────
            System.out.println("\n=== Lab 2: Statement 사용 ===");
            try (Statement stmt = conn.createStatement()) {
                // DDL: 테이블 생성
                stmt.execute("CREATE TABLE IF NOT EXISTS users " +
                             "(id INT PRIMARY KEY, name VARCHAR(50))");

                // DML: 데이터 삽입
                stmt.executeUpdate("INSERT INTO users VALUES (1, 'kim')");
                stmt.executeUpdate("INSERT INTO users VALUES (2, 'lee')");

                // DQL: 데이터 조회
                String sql = "SELECT * FROM users"; // → 문제 2 핵심
                System.out.println("실행 쿼리: " + sql);
                ResultSet rs = stmt.executeQuery(sql);

                // ─────────────────────────────────────────────
                // Lab 4: ResultSet 읽기 (→ 문제 4 참고)
                // ─────────────────────────────────────────────
                System.out.println("\n=== Lab 4: ResultSet 읽기 ===");
                while (rs.next()) { // rs.next() → 다음 행으로 이동, 없으면 false
                    int id     = rs.getInt("id");
                    String name = rs.getString("name");
                    System.out.println("  id=" + id + ", name=" + name);
                }
            }

            // ─────────────────────────────────────────────
            // Lab 3: PreparedStatement — SQL Injection 방지 (→ 문제 3 참고)
            // ─────────────────────────────────────────────
            System.out.println("\n=== Lab 3: PreparedStatement (SQL Injection 방지) ===");
            System.out.println("[위험] Statement 방식:");
            System.out.println("  String sql = \"SELECT * FROM users WHERE name = '\" + input + \"'\";");
            System.out.println("  → input = \"'; DROP TABLE users; --\" 이면 테이블 삭제!");
            System.out.println();
            System.out.println("[안전] PreparedStatement 방식:");
            System.out.println("  ? 플레이스홀더로 파라미터 분리 → 자동 이스케이프");

            // PreparedStatement 실제 사용
            String safeSql = "SELECT * FROM users WHERE name = ?"; // ? 플레이스홀더
            try (PreparedStatement pstmt = conn.prepareStatement(safeSql)) {
                pstmt.setString(1, "kim"); // 1번째 ? 에 "kim" 바인딩
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    System.out.println("  PreparedStatement 조회: id=" + rs.getInt("id")
                            + ", name=" + rs.getString("name"));
                }
            }

            // INSERT PreparedStatement
            String insertSql = "INSERT INTO users VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
                pstmt.setInt(1, 3);
                pstmt.setString(2, "park");
                int rows = pstmt.executeUpdate();
                System.out.println("  삽입된 행 수: " + rows);
            }

        } catch (SQLException e) {
            System.out.println("DB 오류 (H2 드라이버가 없으면 발생): " + e.getMessage());
            System.out.println("실제 프로젝트에서는 build.gradle에 드라이버 의존성을 추가해야 합니다.");
        }

        // ─────────────────────────────────────────────
        // Lab 5: try-with-resources 설명 (→ 문제 5 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 5: try-with-resources (자원 자동 반납) ===");
        /*
         * [올바른 JDBC 자원 반납 구조]
         *
         * try (Connection conn = DriverManager.getConnection(url, user, pass);
         *      PreparedStatement pstmt = conn.prepareStatement(sql);
         *      ResultSet rs = pstmt.executeQuery()) {
         *
         *     while (rs.next()) { ... }
         *
         * } // 블록 종료 시 rs → pstmt → conn 순으로 자동 close()
         *
         * [왜 중요한가]
         *  - DB 서버의 연결(세션) 수는 제한적 (보통 100~1000개)
         *  - close() 안 하면 연결이 계속 점유 → 연결 풀 고갈 → 서버 다운
         *  - try-with-resources: 예외 발생 시에도 반드시 close() 보장
         */
        System.out.println("try-with-resources: 블록 종료 시 rs → pstmt → conn 순으로 자동 close()");
        System.out.println("예외 발생 시에도 close() 보장 → DB 연결 누수(leak) 방지");
    }
}
