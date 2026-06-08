package week06.day2;

/**
 * [학습 예제 1] Week 06 Day 2 — 메서드 오버라이딩(Overriding)과 Object API
 * 
 * [학습 핵심 이론: 메서드 오버라이딩과 Object 클래스]
 * 1. 메서드 오버라이딩 (Method Overriding):
 *    - 상속받은 부모의 메서드를 자식 클래스의 특성에 맞게 '동일한 이름, 동일한 매개변수, 동일한 반환타입'으로 재정의하는 다형성 핵심 기법입니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: Animal 클래스 메서드 오버라이딩 (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        dog.sound();
        cat.sound();
    }

    // Problem 1: Animal - Dog - Cat
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
    }

    static class Cat extends Animal {
        @Override
        void sound() {
            System.out.println("야옹");
        }
    }
}
