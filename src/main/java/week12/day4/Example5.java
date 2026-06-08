package week12.day4;

/**
 * [학습 예제 5] Week 12 Day 4 — JDBC 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 5] try-with-resources (자원 자동 반납)
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - JDBC 객체들은 AutoCloseable 구현 → try-with-resources 사용 가능
 *  - 예외 발생 시에도 반드시 close() 보장 → DB 연결 누수 방지
 *
 * [문제별 학습 목표]
 * - 문제 5: try-with-resources — 자원 자동 반납
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("\n=== Lab 5: try-with-resources (자원 자동 반납) ===");
        System.out.println("try-with-resources: 블록 종료 시 rs → pstmt → conn 순으로 자동 close()");
        System.out.println("예외 발생 시에도 close() 보장 → DB 연결 누수(leak) 방지");
    }
}
