package week05.day2;

/**
 * [학습 예제] Week 05 Day 2 — 생성자(Constructor)
 * Lab1~Lab5를 순서대로 실행하며 각 개념을 익히세요.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 05 Day 2 학습 예제 ===\n");

        System.out.println("--- Lab1: 기본 생성자 ---");
        Lab1.run();
        System.out.println("\n[해설] 생성자를 하나도 안 만들면 자바가 자동으로 빈 생성자를 넣어줍니다.\n");

        System.out.println("--- Lab2: 매개변수 생성자 ---");
        Lab2.run();
        System.out.println("\n[해설] 객체 생성 시점에 데이터를 전달받아 필드를 초기화할 수 있습니다.\n");

        System.out.println("--- Lab3: 생성자 오버로딩 ---");
        Lab3.run();
        System.out.println("\n[해설] 매개변수의 개수나 타입이 다르면 여러 개의 생성자를 만들 수 있습니다.\n");

        System.out.println("--- Lab4: this 키워드 ---");
        Lab4.run();
        System.out.println("\n[해설] this는 객체 자신을 가리키며, 필드명과 매개변수명이 같을 때 구분하기 위해 사용합니다.\n");

        System.out.println("--- Lab5: this() 생성자 체이닝 ---");
        Lab5.run();
        System.out.println("\n[해설] this()를 사용하면 한 생성자에서 다른 생성자를 호출하여 중복 코드를 줄일 수 있습니다.\n");
    }

    static class Person {
        String name;
        int age;

        // Lab1: 기본 생성자
        Person() {
            System.out.println("기본 생성자가 호출되었습니다.");
        }

        // Lab2, Lab4: 매개변수 생성자 + this
        Person(String name, int age) {
            this.name = name; // this.name은 필드, name은 매개변수
            this.age = age;
        }

        // Lab3: 오버로딩 (이름만 받는 생성자)
        Person(String name) {
            this(name, 1); // Lab5: 다른 생성자 호출 (체이닝)
        }

        void showInfo() {
            System.out.println("이름: " + name + ", 나이: " + age);
        }
    }

    static class Lab1 {
        static void run() {
            new Person();
        }
    }

    static class Lab2 {
        static void run() {
            Person p = new Person("자바군", 25);
            p.showInfo();
        }
    }

    static class Lab3 {
        static void run() {
            Person p1 = new Person("이름만");
            Person p2 = new Person("둘다", 30);
            p1.showInfo();
            p2.showInfo();
        }
    }

    static class Lab4 {
        static void run() {
            System.out.println("this 키워드를 통해 필드와 매개변수를 명확히 구분했습니다.");
        }
    }

    static class Lab5 {
        static void run() {
            System.out.println("this()를 사용해 '이름만' 받는 생성자가 '둘다' 받는 생성자를 호출했습니다.");
        }
    }
}
