package week06.day2;

/**
 * [학습 예제 4] Week 06 Day 2 — 메서드 오버라이딩(Overriding)과 Object API
 * 
 * [학습 핵심 이론: 메서드 오버라이딩과 Object 클래스]
 * 3. super 키워드로 부모 기능 확장:
 *    - 오버라이딩 시 부모의 원래 기능을 완전히 버리지 않고, `super.부모메서드()`로 먼저 호출한 뒤 자식의 개별 로직을 덧붙여 기능을 우아하게 확장할 수 있습니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: super.메서드() 호출을 이용한 부모 기능의 확장 (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.showAndSound();
    }

    static class Animal {
        void sound() {
            System.out.println("동물이 내는 일반적인 소리");
        }
    }

    static class Dog extends Animal {
        @Override
        void sound() {
            System.out.println("멍멍");
        }

        void showAndSound() {
            super.sound(); 
            System.out.println("-> [확장] 나는 멍멍 짖는 강아지입니다.");
        }
    }
}
