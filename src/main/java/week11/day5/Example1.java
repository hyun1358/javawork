package week11.day5;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * [학습 예제 1] Week 11 Day 5 — 리플렉션(Reflection) 완전 정복
 *
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * [핵심 이론 1] 클래스 메타데이터 조회
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 *  - 모든 클래스는 Class<?> 객체를 가짐
 *  - Class.getDeclaredFields(): 해당 클래스에서 선언된 모든 필드
 *  - Class.getDeclaredMethods(): 해당 클래스에서 선언된 모든 메서드
 *  - Class.getFields() / getMethods(): public 필드/메서드 (상속 포함)
 *
 * [문제별 학습 목표]
 * - 문제 1: 클래스 정보 출력 — String.class 의 필드 개수 / 메서드 개수
 */
public class Example1 {
    public static void main(String[] args) throws Exception {
        // ─────────────────────────────────────────────
        // Lab 1: 클래스 정보 출력 (→ 문제 1 참고)
        // ─────────────────────────────────────────────
        System.out.println("=== Lab 1: 클래스 정보 출력 ===");
        // String.class 를 통해 String 클래스 메타정보 조회
        Class<?> strClass = String.class;
        System.out.println("클래스명: " + strClass.getName());
        System.out.println("선언된 필드 수: " + strClass.getDeclaredFields().length);
        System.out.println("선언된 메서드 수: " + strClass.getDeclaredMethods().length);

        // 사용자 정의 클래스 정보 출력
        Class<?> personClass = Person.class;
        System.out.println("\nPerson 클래스 필드들:");
        for (Field f : personClass.getDeclaredFields()) {
            System.out.println("  - " + f.getName() + " (" + f.getType().getSimpleName() + ")");
        }
        System.out.println("Person 클래스 메서드들:");
        for (Method m : personClass.getDeclaredMethods()) {
            System.out.println("  - " + m.getName() + "()");
        }
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

        public void greet() {
            System.out.println("안녕하세요, 저는 " + name + "이고 " + age + "살입니다.");
        }
    }
}
