package week12.day5;

/**
 * [예습 파일] Week 12 Day 5 — 아키텍처 계층 분리
 * 
 * [핵심 개념: 역할의 분리 - 3-Tier Layered Architecture]
 * 1. 단일 책임 원칙과 스파게티 코드의 극복:
 *    - 하나의 클래스 내에 웹 통신, 비즈니스 계산 연산, DB 쿼리 저장 호출까지 스파게티처럼 다 섞어두면 코드를 고치다 다른 곳이 파괴되는 재앙이 생깁니다.
 * 
 * 2. 표준 3계층 아키텍처 (Layered Architecture):
 *    - Presentation Layer (Controller): 사용자 요청을 받고 최종 화면/응답을 쏘아주는 최전방 계층입니다.
 *    - Business Logic Layer (Service): 핵심 비즈니스 연산과 비즈니스 룰 검증을 독점 제어하는 중추 계층입니다.
 *    - Data Access Layer (Repository / DAO): DB에 직접 들러 데이터를 CRUD하는 저장소 계층입니다.
 */
public class Preview {
    public static void main(String[] args) {
        // Controller (UI) -> Service (비즈니스 로직) -> Repository (데이터 접근)
        System.out.println("계층이 분리되어 있으면 데이터베이스를 바꾸더라도 UI 코드는 건드리지 않아도 됩니다.");
    }
}
