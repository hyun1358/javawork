package week06.day4;

/**
 * [학습 예제 3] Week 06 Day 4 — 추상 클래스(Abstract Class)와 템플릿 메서드 패턴
 * 
 * [학습 핵심 이론: 추상 클래스를 통한 표준 설계 규격]
 * 1. 추상 클래스 (Abstract Class, `abstract class`):
 *    - 아직 온전히 완성되지 않은 미완성 설계도입니다.
 *    - 인스턴스화가 완전 차단되므로 `new` 연산자로 직접 객체를 생성할 수 없습니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: 추상 클래스의 인스턴스 생성 불가 제약사항 검증 (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        // Animal ani = new Animal(); // [컴파일 에러!] 'Animal is abstract; cannot be instantiated'
        System.out.println("[추상 클래스 인스턴스화 차단]");
        System.out.println("-> 추상 클래스는 본체에 구현되지 않은 빈 껍데기(추상 메서드)가 섞여 있어 불완전하므로 직접 new 할 수 없습니다.");
    }
}
