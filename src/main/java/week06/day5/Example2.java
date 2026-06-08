package week06.day5;

/**
 * [학습 예제 2] Week 06 Day 5 — 인터페이스(Interface)와 다중 구현
 * 
 * [학습 핵심 이론: 인터페이스를 통한 다형성 극대화]
 * 2. 다중 구현 (Multiple Implementation):
 *    - 자바는 클래스 간 단일 상속만 허용하여 복잡성과 꼬임 문제를 막는 대신, 인터페이스 다중 구현(`implements A, B`)을 완벽히 허용하여 느슨한 결합(Loose Coupling)과 대안적 다중 상속을 실현합니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: 인터페이스 다중 구현을 만족하는 Duck 클래스 (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.swim();
        duck.fly();
    }

    // Problem 2: Swimeable 인터페이스와 다중 구현 Duck
    interface Swimeable {
        void swim();
    }

    interface Flyable {
        void fly();
    }

    // Swimeable과 Flyable을 동시 다중 구현
    static class Duck implements Swimeable, Flyable {
        @Override
        public void swim() {
            System.out.println("오리가 둥근 물갈퀴 발을 저으며 물속을 평화롭게 헤엄칩니다.");
        }

        @Override
        public void fly() {
            System.out.println("오리가 넓은 날개를 퍼덕이며 낮게 비행합니다.");
        }
    }
}
