package week11.day5;

import java.lang.reflect.Field;

/**
 * [학습 예제 4] Week 11 Day 5 — 리플렉션(Reflection) 완전 정복
 *
 * [문제별 학습 목표]
 * - 문제 4: 객체 복사 (Shallow Copy) — 모든 필드 값을 다른 객체로 복사
 */
public class Example4 {
    public static void main(String[] args) throws Exception {
        // ─────────────────────────────────────────────
        // Lab 4: 객체 복사 (Shallow Copy) (→ 문제 4 참고)
        // ─────────────────────────────────────────────
        System.out.println("\n=== Lab 4: 리플렉션으로 객체 복사 (Shallow Copy) ===");
        Person original = new Person("김철수", 30);
        Person copy = new Person(null, 0);

        // 모든 필드를 리플렉션으로 순회하며 값 복사
        for (Field f : Person.class.getDeclaredFields()) {
            f.setAccessible(true);
            f.set(copy, f.get(original)); // 원본 → 복사본
        }

        System.out.println("원본: name=" + original.getName() + ", age=" + original.getAge());

        Field nameField = Person.class.getDeclaredField("name");
        nameField.setAccessible(true);
        Field copyAgeField = Person.class.getDeclaredField("age");
        copyAgeField.setAccessible(true);
        System.out.println("복사본: name=" + nameField.get(copy) + ", age=" + copyAgeField.get(copy));
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
