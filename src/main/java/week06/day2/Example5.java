package week06.day2;

/**
 * [학습 예제 5] Week 06 Day 2 — 메서드 오버라이딩(Overriding)과 Object API
 * 
 * [학습 핵심 이론: 메서드 오버라이딩과 Object 클래스]
 * 4. @Override 어노테이션의 가치:
 *    - 컴파일러에게 "이 메서드는 오버라이딩된 것"임을 명시적으로 통보합니다.
 *    - 만약 부모 메서드 이름에 오타를 내어 잘못 선언하는 실수를 컴파일 에러로 미리 완벽하게 잡아내 줍니다.
 * 
 * [문제별 학습 목표]
 * - Lab5: @Override 어노테이션의 중요성 및 컴파일러 안전망 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("[@Override 어노테이션의 핵심 역할]");
        System.out.println("1. 개발자가 toString() 대신 toStrng()과 같이 오타를 치면, 컴파일러가 '부모에 그런 메서드가 없다'며 즉시 빌드 에러를 냅니다.");
        System.out.println("2. 어노테이션을 생략하면 단순 '새로운 메서드 정의'로 오인되어 런타임에 오버라이딩이 오작동하는 대형 버그로 이어집니다.");
    }
}
