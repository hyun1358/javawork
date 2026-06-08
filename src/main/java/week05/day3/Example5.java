package week05.day3;

/**
 * [학습 예제 5] Week 05 Day 3 — 접근 제어자와 캡슐화
 * 
 * [문제별 학습 목표]
 * - Lab5: 왜 public 대신 private 필드를 쓰는가? (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("[캡슐화의 핵심 가치 요약]");
        System.out.println("1. 필드를 public으로 개방하면 외부의 의도치 않은 임의 수정에 의해 데이터가 심각히 오염될 수 있습니다.");
        System.out.println("2. 필드를 private으로 선언하고 오직 검증(Validation)이 통과된 데이터만 setter/메서드를 통해 반영되도록 유도합니다.");
        System.out.println("3. 이를 통해 객체의 무결성(Integrity)이 확실히 보장되고 유지보수가 훨씬 용이해집니다.");
    }
}
