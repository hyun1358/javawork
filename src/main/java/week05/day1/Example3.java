package week05.day1;

/**
 * [학습 예제 3] Week 05 Day 1 — 클래스와 객체의 기초
 * 
 * [문제별 학습 목표]
 * - Lab3: 한 설계도로부터 여러 고유 객체 만들기 (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        // 2개의 Person 객체 독립 생성
        Person p1 = new Person("홍길동", 20);
        Person p2 = new Person("이순신", 45);
        p1.init();
        p2.init();
    }

    // Problem 3 연계 Person 클래스 정의
    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        void init() {
            System.out.printf("%s(%d세)\n", name, age);
        }
    }
}
