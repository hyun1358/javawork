package week11.day6;

/**
 * [미니 프로젝트 가이드] Week 11 Day 6 — 간단한 ORM 시뮬레이터
 * <p>
 * [미션]
 * 커스텀 어노테이션(@Table, @Column)과 리플렉션을 활용하여
 * Java 객체를 바탕으로 "CREATE TABLE ..." 또는 "INSERT INTO ..." 형태의
 * SQL 쿼리 문자열을 자동으로 만들어주는 엔진을 구현하세요.
 * <p>
 * [요구사항]
 * 1. @Table(name="테이블명"), @Column(name="컬럼명") 어노테이션 생성
 * 2. User 엔티티 클래스 생성 후 어노테이션 부여
 * 3. OrmEngine 클래스에 String generateInsertQuery(Object obj) 메서드를 만들고,
 * 리플렉션으로 객체의 값과 어노테이션을 읽어 "INSERT INTO users(id, name) VALUES(1, '홍길동');"
 * 문자열을 반환하게 합니다.
 */
public class MiniProjectGuide {
}
