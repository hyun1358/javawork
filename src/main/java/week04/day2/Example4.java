package week04.day2;

/**
 * [학습 예제 4] Week 04 Day 2 — 메서드 매개변수 심화
 * 
 * [학습 핵심 이론: Call by Value 매커니즘 및 다형적 호출]
 * 5. 메서드 오버로딩 (Method Overloading):
 *    - 같은 이름의 메서드를 매개변수의 개수나 타입을 다르게 하여 여러 개 정의하는 기법입니다.
 *    - 인자 개수가 적은 오버로딩 메서드가 기본값(Default value)을 넘겨주며 인자가 많은 오버로딩 메서드를 호출하는 연쇄 호출 패턴은 실무에서 매우 자주 쓰입니다.
 * 
 * [문제별 학습 목표]
 * - Lab5: 메서드 오버로딩과 기본값 지정 연쇄 호출 (Problem 5 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        // Problem 5: 메서드 오버로딩 (기본값 설정 패턴) 호출
        greet(); // 매개변수 없음 -> 손님 출력
        greet("홍길동"); // 매개변수 있음 -> 이름 출력
    }

    // 이름이 들어오는 오버로딩 메서드
    static void greet(String name) {
        System.out.println("안녕하세요, " + name + "님!");
    }

    // 인자가 생략되었을 때 호출되는 오버로딩 메서드
    static void greet() {
        // 중복 코드를 작성하는 대신, 기본값인 "손님"을 주어 위의 greet(String)을 호출합니다.
        greet("손님"); 
    }
}
