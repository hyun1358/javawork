package week12.day4;

/**
 * [학습 예제] Week 12 Day 4 — JDBC의 흐름
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab: JDBC 필수 4단계 흐름 ===");
        System.out.println("1. Connection 객체 얻기 (DriverManager)");
        System.out.println("2. PreparedStatement 객체 생성 (SQL 세팅)");
        System.out.println("3. executeQuery() 또는 executeUpdate() 호출");
        System.out.println("4. ResultSet(조회 시) 읽기 및 모든 자원 close()");
    }
}
