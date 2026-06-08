package week11.day5;

import java.lang.reflect.Field;

/**
 * [학습 예제 2] Week 11 Day 5 — 리플렉션(Reflection) 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 2] private 필드 강제 접근
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - getDeclaredField("필드명"): 해당 클래스의 필드 객체 가져옴
 *  - field.setAccessible(true): private 접근 제한 해제
 *  - field.get(obj): 필드 값 읽기
 *  - field.set(obj, value): 필드 값 쓰기
 *
 * [문제별 학습 목표]
 * - 문제 2: private 필드 읽기 — setAccessible(true) 로 캡슐화 우회
 */
public class Example2 {
    public static void main(String[] args) throws Exception {
        // ─────────────────────────────────────────────
        // Lab 2: private 필드 읽기 (→ 문제 2 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 2: private 필드 읽기 ===");
        Person person = new Person("홍길동", 25);

        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true); // private 접근 제한 해제

        int age = (int) ageField.get(person);
        System.out.println("리플렉션으로 읽은 private age: " + age);

        // private 필드 값 변경도 가능
        ageField.set(person, 99);
        System.out.println("리플렉션으로 변경 후 age: " + ageField.get(person));
    }

    // ─── 예제 클래스 ──────────────────────────────────────
    static class Person {
        private String name;
        private int age;

        Person(String name, int age) {
            this.name = name;
            this.age  = age;
        }

        public String getName() { return name; }
        public int getAge()     { return age; }
    }
}
