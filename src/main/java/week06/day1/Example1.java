package week06.day1;

/**
 * [학습 예제 1] Week 06 Day 1 — 객체지향 상속(Inheritance)과 super
 * 
 * [학습 핵심 이론: 객체지향의 상속 매커니즘]
 * 1. 상속(Inheritance)의 정의와 목적:
 *    - 기존 클래스(부모 / Super Class)의 필드와 메서드를 자식 클래스(Sub Class)가 온전히 물려받아(extends) 재사용함으로써 코드 중복을 제거하고 다형적 설계의 기반을 닦습니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: Animal 클래스 상속과 필드 공유 (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        Dog dog = new Dog("바둑이");
        Cat cat = new Cat("나비");
        dog.showName();
        cat.showName();
    }

    // Problem 1: Animal 클래스 계층
    static class Animal {
        String name;

        void showName() {
            System.out.println("동물 이름: " + name);
        }
    }

    static class Dog extends Animal {
        Dog(String name) {
            this.name = name; // 부모로부터 상속받은 필드 직접 초기화
        }
    }

    static class Cat extends Animal {
        Cat(String name) {
            this.name = name;
        }
    }
}
