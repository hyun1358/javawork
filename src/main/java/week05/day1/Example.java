package week05.day1;

import java.util.Arrays;

/**
 * [학습 예제] Week 05 Day 1 — 클래스와 객체의 기초 (Dog 짖기, Car 주행, 다중 인스턴스, 사각형 계산기, 객체 배열 활용)
 * 
 * [학습 핵심 이론: 객체지향 프로그래밍(OOP) 기초]
 * 1. 클래스(Class)와 객체(Object):
 *    - 클래스는 현실의 객체를 자바 프로그램에서 정의하는 '설계도(Blueprint)'입니다.
 *    - 객체는 설계도로부터 메모리(Heap)에 생성된 실체(Instance)입니다.
 * 
 * 2. 상태(Fields)와 행위(Methods):
 *    - 필드는 객체가 가지는 데이터 속성을 저장하는 멤버 변수입니다.
 *    - 메서드는 객체가 수행하는 행동이나 함수적 연산입니다.
 * 
 * 3. 객체 배열 (Object Array):
 *    - 객체 배열은 객체 자체가 직접 들어가는 것이 아니라, 객체가 생성된 힙(Heap) 주소를 가리키는 '참조값'들이 배열의 각 칸에 들어가는 배열 구조입니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 05 Day 1 학습 예제 ===\n");

        System.out.println("--- Lab1: Dog 클래스 설계와 bark() 호출 (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: Car 클래스 설계와 포맷팅 출력 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: 한 설계도로부터 여러 고유 객체 만들기 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: Rectangle 클래스의 상태 기반 면적/둘레 계산 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: 객체 배열(Student Array)의 선언 및 일괄 제어 (Problem 5 연계) ---");
        Lab5.run();
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

    // Problem 2 연계 Car 클래스 정의
    static class Car {
        String brand;
        int speed;
        String color;

        Car(String brand, int speed, String color) {
            this.brand = brand;
            this.speed = speed;
            this.color = color;
        }

        void drive() {
            System.out.printf("[%s]의 [%s] 차가 [%d]km/h로 달립니다.\n", brand, color, speed);
        }
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

    // Problem 4 연계 Rectangle 클래스 정의
    static class Rectangle {
        int width;
        int height;

        Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        int getArea() {
            return width * height;
        }

        int getPerimeter() {
            return 2 * (width + height);
        }
    }

    // Problem 5 연계 Student 클래스 정의
    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    static class Lab1 {
        static void run() {
            // Dog 객체 생성 및 bark 실행
            Dog dog = new Dog("바둑이", 4, "리트리버");
            dog.bark();
        }
    }

    static class Lab2 {
        static void run() {
            // Car 객체 생성 및 drive 실행
            Car myCar = new Car("현대", 120, "빨간색");
            myCar.drive();
        }
    }

    static class Lab3 {
        static void run() {
            // 2개의 Person 객체 독립 생성
            Person p1 = new Person("홍길동", 20);
            Person p2 = new Person("이순신", 45);
            p1.init();
            p2.init();
        }
    }

    static class Lab4 {
        static void run() {
            // 가로 10, 세로 20의 사각형 생성 및 수식 테스트
            Rectangle rect = new Rectangle(10, 20);
            System.out.println("가로 10, 세로 20 사각형 넓이: " + rect.getArea());
            System.out.println("가로 10, 세로 20 사각형 둘레: " + rect.getPerimeter());
        }
    }

    static class Lab5 {
        static void run() {
            // Student 객체 배열 생성 및 반복 제어
            Student[] students = new Student[3];
            students[0] = new Student("홍길동", 85);
            students[1] = new Student("김철수", 92);
            students[2] = new Student("김영희", 78);

            System.out.println("--- 학생 명단 및 점수 ---");
            for (Student s : students) {
                System.out.println("이름: " + s.name + ", 점수: " + s.score);
            }
        }
    }
}
