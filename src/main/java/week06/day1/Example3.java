package week06.day1;

/**
 * [학습 예제 3] Week 06 Day 1 — 객체지향 상속(Inheritance)과 super
 * 
 * [문제별 학습 목표]
 * - Lab3: Employee 클래스 상속 및 직군별 특성 분화 (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        Manager m = new Manager();
        m.name = "김팀장";
        m.dept = "플랫폼개발팀";

        Developer d = new Developer();
        d.name = "홍길동";
        d.lang = "Java";

        System.out.println("매니저: " + m.name + " (" + m.dept + ")");
        System.out.println("개발자: " + d.name + " (" + d.lang + ")");
    }

    // Problem 3: Employee 클래스 계층
    static class Employee {
        String name;
        int salary;
    }

    static class Manager extends Employee {
        String dept;
    }

    static class Developer extends Employee {
        String lang;
    }
}
