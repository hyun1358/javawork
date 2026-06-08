package week05.day1;

/**
 * [학습 예제 1] Week 05 Day 1 — 클래스와 객체의 기초
 * 
 * [학습 핵심 이론: 객체지향 프로그래밍(OOP) 기초]
 * 1. 클래스(Class)와 객체(Object):
 *    - 클래스는 현실의 객체를 자바 프로그램에서 정의하는 '설계도(Blueprint)'입니다.
 *    - 객체는 설계도로부터 메모리(Heap)에 생성된 실체(Instance)입니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: Dog 클래스 설계와 bark() 호출 (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        // Dog 객체 생성 및 bark 실행
        Dog dog = new Dog("바둑이", 4, "리트리버");
        dog.bark();
    }

    // Problem 1 연계 Dog 클래스 정의
    static class Dog {
        String name;
        int age;
        String breed;

        Dog(String name, int age, String breed) {
            this.name = name;
            this.age = age;
            this.breed = breed;
        }

        void bark() {
            System.out.println(name + "(" + breed + ", " + age + "세)가 짖습니다: 멍멍!");
        }
    }
}
