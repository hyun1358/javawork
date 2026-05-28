package week12.day4;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * [예습 파일] Week 12 Day 4 — JDBC 기초
 * 
 * [핵심 개념: 데이터베이스 연결 표준 인터페이스]
 * 1. JDBC (Java Database Connectivity):
 *    - 오라클, MySQL, PostgreSQL 등 전 세계 수많은 DBMS 종류에 상관없이, 자바 개발자가 하나의 일관된 표준 메서드 호출 규격으로 데이터베이스 서버에 접속하고 쿼리를 날릴 수 있도록 돕는 자바 표준 SQL 인터페이스 인터랙션 세트입니다.
 * 
 * 2. JDBC 핵심 객체 3대장:
 *    - Connection: DB 서버와의 물리적 연결 통로(세션)를 독점 확보한 객체입니다.
 *    - PreparedStatement: SQL 쿼리 문을 컴파일하여 실행을 대기시키며, 인자값 주입 시 SQL Injection 공격을 원천 봉쇄해 가독성과 보안을 모두 책임집니다.
 *    - ResultSet: SELECT 쿼리문 실행 후 반환된 격자형 결과 레코드 테이블을 커서(`next()`) 단위로 한 줄씩 포인팅하며 꺼내는 결과 저장소입니다.
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
