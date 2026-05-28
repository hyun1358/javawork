package week06.day1;

/**
 * [학습 예제] Week 06 Day 1 — 객체지향 상속(Inheritance)과 super (Animal 상속, Shape-Circle-Rectangle, Employee-Manager-Developer, Vehicle-Car super호출, 3단계 상속 계층)
 * 
 * [학습 핵심 이론: 객체지향의 상속 매커니즘]
 * 1. 상속(Inheritance)의 정의와 목적:
 *    - 기존 클래스(부모 / Super Class)의 필드와 메서드를 자식 클래스(Sub Class)가 온전히 물려받아(extends) 재사용함으로써 코드 중복을 제거하고 다형적 설계의 기반을 닦습니다.
 * 
 * 2. super 키워드와 부모 생성자 위임:
 *    - 힙 메모리에 자식 객체가 할당될 때, JVM은 부모 객체의 영역을 먼저 초기화해야 합니다.
 *    - 자식 생성자의 첫 줄에는 반드시 `super(...)`를 기입하여 부모 생성자를 위임 호출해야 합니다. 명시하지 않으면 인자 없는 `super()`가 자동으로 삽입되나, 부모 클래스에 매개변수가 있는 생성자만 존재할 경우에는 반드시 자식 생성자에서 `super(인자)`를 직접 기입해야 빌드 에러를 방지할 수 있습니다. (Problem 4 연계)
 * 
 * 3. 3단계 다층 상속 (Multi-level Inheritance):
 *    - 자바는 다중 상속(클래스 2개 이상을 한 번에 상속)은 지원하지 않으나, A -> B -> C와 같은 형태의 수직 다층 상속 구조는 완벽히 허용하며, 최하위 클래스 C의 객체는 A와 B의 필드/메서드를 모두 사용할 수 있습니다. (Problem 5 연계)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 06 Day 1 학습 예제 ===\n");

        System.out.println("--- Lab1: Animal 클래스 상속과 필드 공유 (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: Shape 클래스 상속 및 자식별 개별 연산 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: Employee 클래스 상속 및 직군별 특성 분화 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: super()를 이용한 부모 매개변수 생성자 위임 호출 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: A -> B -> C 3단계 수직 상속 계층 동작 (Problem 5 연계) ---");
        Lab5.run();
    }

    // Problem 1: Animal 클래스 계층
    static class Animal {
        String name;

        void showName() {
            System.out.println("동물 이름: " + name);
        }
    }

    static class Dog extends Animal {
        Dog(String name) {
            this.name = name; // 부모로부터 상속받은 필드 직접 초기화
        }
    }

    static class Cat extends Animal {
        Cat(String name) {
            this.name = name;
        }
    }

    // Problem 2: Shape 클래스 계층
    static class Shape {
        String color;
    }

    static class Circle extends Shape {
        int radius;

        Circle(int radius, String color) {
            this.radius = radius;
            this.color = color; // 상속받은 필드
        }

        void showArea() {
            double area = radius * radius * 3.14;
            System.out.printf("[%s 원] 반지름: %d | 면적: %.2f\n", color, radius, area);
        }
    }

    static class Rectangle extends Shape {
        int width, height;

        Rectangle(int width, int height, String color) {
            this.width = width;
            this.height = height;
            this.color = color;
        }

        void showArea() {
            int area = width * height;
            System.out.printf("[%s 사각형] 가로 %d x 세로 %d | 면적: %d\n", color, width, height, area);
        }
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

    // Problem 4: super() 활용 Vehicle & Car
    static class Vehicle {
        String brand;

        Vehicle(String brand) {
            this.brand = brand;
        }
    }

    static class Car extends Vehicle {
        int speed;

        Car(String brand, int speed) {
            super(brand); // 필수: 부모 생성자 호출 (전달인자 매핑)
            this.speed = speed;
        }

        void showInfo() {
            System.out.println("브랜드: " + brand + " | 속도: " + speed + "km/h");
        }
    }

    // Problem 5: 3단계 상속 (A -> B -> C)
    static class A {
        void methodA() { System.out.println("A 클래스의 methodA 실행"); }
    }

    static class B extends A {
        void methodB() { System.out.println("B 클래스의 methodB 실행"); }
    }

    static class C extends B {
        void methodC() { System.out.println("C 클래스의 methodC 실행"); }
    }

    static class Lab1 {
        static void run() {
            Dog dog = new Dog("바둑이");
            Cat cat = new Cat("나비");
            dog.showName();
            cat.showName();
        }
    }

    static class Lab2 {
        static void run() {
            Circle c = new Circle(5, "빨강");
            Rectangle r = new Rectangle(10, 5, "파랑");
            c.showArea();
            r.showArea();
        }
    }

    static class Lab3 {
        static void run() {
            Manager m = new Manager();
            m.name = "김팀장";
            m.dept = "플랫폼개발팀";

            Developer d = new Developer();
            d.name = "홍길동";
            d.lang = "Java";

            System.out.println("매니저: " + m.name + " (" + m.dept + ")");
            System.out.println("개발자: " + d.name + " (" + d.lang + ")");
        }
    }

    static class Lab4 {
        static void run() {
            Car myCar = new Car("현대", 180);
            myCar.showInfo();
        }
    }

    static class Lab5 {
        static void run() {
            C obj = new C();
            obj.methodA(); // A에서 상속
            obj.methodB(); // B에서 상속
            obj.methodC(); // C 자체 선언
        }
    }
}
