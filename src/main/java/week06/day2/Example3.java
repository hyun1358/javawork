package week06.day2;

import java.util.Objects;

/**
 * [학습 예제 3] Week 06 Day 2 — 메서드 오버라이딩(Overriding)과 Object API
 * 
 * [학습 핵심 이론: 메서드 오버라이딩과 Object 클래스]
 * 2. 최상위 조상 Object 클래스:
 *    - `equals(Object)`: 물리적인 주소 비교(`==`)가 아닌, 논리적인 동등성(State equality)을 비교하기 위해 오버라이딩합니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: equals() 재정의를 통한 논리적 동등성(값) 비교 (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        Person p1 = new Person("홍길동", 20);
        Person p2 = new Person("홍길동", 20);
        Person p3 = new Person("이순신", 45);

        System.out.println("p1.equals(p2) [동일 값 객체]: " + p1.equals(p2));
        System.out.println("p1.equals(p3) [서로 다른 값 객체]: " + p1.equals(p3));
        System.out.println("p1 == p2 [주소값 비교]: " + (p1 == p2));
    }

    // Problem 3: Person equals
    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Person p = (Person) obj;
            return age == p.age && Objects.equals(name, p.name);
        }
    }
}
