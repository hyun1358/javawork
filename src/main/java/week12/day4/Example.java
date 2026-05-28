package week12.day4;

/**
 * [학습 예제] Week 12 Day 4 — JDBC 연결 및 리소스 반환 흐름
 * 
 * [학습 핵심 이론: JDBC의 완벽한 자원 해제 라이프사이클]
 * 1. DB 커넥션 리소스 정리의 중요성:
 *    - DB 연결은 매우 비싸고 한정적인 자원이라 절대 방치하면 안 됩니다.
 *    - ResultSet -> PreparedStatement -> Connection 역순으로 반드시 안전하게 `.close()`를 해주어야 DB 서버의 세션 고갈을 피할 수 있습니다.
 *    - try-with-resources에 이들을 모두 등록하여 에러가 터져도 빈틈없이 자동 클로즈가 수행되도록 탄탄하게 구축합니다.
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
