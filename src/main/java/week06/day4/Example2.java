package week06.day4;

/**
 * [학습 예제 2] Week 06 Day 4 — 추상 클래스(Abstract Class)와 템플릿 메서드 패턴
 * 
 * [학습 핵심 이론: 추상 클래스를 통한 표준 설계 규격]
 * 3. 추상과 일반의 공존:
 *    - 추상 클래스는 일반 필드, 일반 메서드, 생성자를 가질 수 있어 공통 기능은 직접 구현하고 개별 가공이 필요한 기능만 추상화할 수 있습니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: 추상 클래스 Animal 내의 추상/일반 메서드 공존 (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.breathe(); // 일반 메서드
        dog.sound();   // 오버라이딩된 추상 메서드
    }

    // Problem 2: Animal 추상/일반 공존
    static abstract class Animal {
        abstract void sound(); // 추상 메서드 (자식이 오버라이딩 강제)

        void breathe() { // 일반 메서드 (공통 코드 제공)
            System.out.println("생명체가 코로 공기를 빨아들여 조용히 숨을 쉽니다.");
        }
    }

    static class Dog extends Animal {
        @Override
        void sound() {
            System.out.println("멍멍!");
        }
    }
}
