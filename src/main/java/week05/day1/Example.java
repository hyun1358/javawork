package week05.day1;

/**
 * [학습 예제] Week 05 Day 1 — 클래스와 객체 개념
 * Lab1~Lab5를 순서대로 실행하며 각 개념을 익히세요.
 * 각 Lab 실행 후 출력된 [해설]을 꼭 읽어보세요.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 05 Day 1 학습 예제 ===\n");

        System.out.println("--- Lab1: 클래스와 필드 선언 ---");
        Lab1.run();
        System.out.println("\n[해설] 클래스는 객체를 만들기 위한 '설계도'이며, 필드는 그 객체가 가지는 '상태'입니다.\n");

        System.out.println("--- Lab2: 메서드 선언 ---");
        Lab2.run();
        System.out.println("\n[해설] 메서드는 객체가 할 수 있는 '동작'을 정의합니다.\n");

        System.out.println("--- Lab3: 객체 생성 (new) ---");
        Lab3.run();
        System.out.println("\n[해설] new 연산자를 통해 설계도(클래스)로부터 실체(인스턴스)를 메모리에 생성합니다.\n");

        System.out.println("--- Lab4: . 연산자로 접근하기 ---");
        Lab4.run();
        System.out.println("\n[해설] 도트(.) 연산자를 사용하면 객체의 내부 필드와 메서드에 접근할 수 있습니다.\n");

        System.out.println("--- Lab5: 여러 객체 생성 ---");
        Lab5.run();
        System.out.println("\n[해설] 하나의 설계도로 여러 개의 서로 다른 실체를 만들 수 있습니다.\n");
    }

    // 설계도 예시: 고양이 클래스
    static class Cat {
        String name;
        int age;

        void meow() {
            System.out.println(name + ": 야옹~");
        }
    }

    static class Lab1 {
        static void run() {
            // 클래스 내부에는 변수(필드)를 선언할 수 있습니다.
            System.out.println("Cat 클래스에 name과 age 필드를 정의했습니다.");
        }
    }

    static class Lab2 {
        static void run() {
            // 클래스 내부에는 동작(메서드)을 정의할 수 있습니다.
            System.out.println("Cat 클래스에 meow() 메서드를 정의했습니다.");
        }
    }

    static class Lab3 {
        static void run() {
            Cat myCat = new Cat(); // Cat 객체 생성
            System.out.println("Cat 객체 생성 완료: " + myCat);
        }
    }

    static class Lab4 {
        static void run() {
            Cat myCat = new Cat();
            myCat.name = "나비"; // 필드 접근
            myCat.age = 2;
            myCat.meow(); // 메서드 호출
        }
    }

    static class Lab5 {
        static void run() {
            Cat cat1 = new Cat();
            cat1.name = "치즈";

            Cat cat2 = new Cat();
            cat2.name = "고등어";

            System.out.println("첫 번째 고양이 이름: " + cat1.name);
            System.out.println("두 번째 고양이 이름: " + cat2.name);
        }
    }
}
