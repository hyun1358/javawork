package week06.day2;

import java.util.Objects;

/**
 * [학습 예제] Week 06 Day 2 — 메서드 오버라이딩(Overriding)과 Object API (Animal 소리 재정의, Book의 toString, Person의 equals, super 메서드 위임, @Override 안전망)
 * 
 * [학습 핵심 이론: 메서드 오버라이딩과 Object 클래스]
 * 1. 메서드 오버라이딩 (Method Overriding):
 *    - 상속받은 부모의 메서드를 자식 클래스의 특성에 맞게 '동일한 이름, 동일한 매개변수, 동일한 반환타입'으로 재정의하는 다형성 핵심 기법입니다.
 * 
 * 2. 최상위 조상 Object 클래스:
 *    - 자바의 모든 클래스는 암묵적으로 `java.lang.Object` 클래스를 상속받습니다.
 *    - `toString()`: 객체의 상태를 문자열로 쉽게 모니터링하기 위해 오버라이딩합니다. (Problem 2 연계)
 *    - `equals(Object)`: 물리적인 주소 비교(`==`)가 아닌, 논리적인 동등성(State equality)을 비교하기 위해 오버라이딩합니다. (Problem 3 연계)
 * 
 * 3. super 키워드로 부모 기능 확장:
 *    - 오버라이딩 시 부모의 원래 기능을 완전히 버리지 않고, `super.부모메서드()`로 먼저 호출한 뒤 자식의 개별 로직을 덧붙여 기능을 우아하게 확장할 수 있습니다. (Problem 4 연계)
 * 
 * 4. @Override 어노테이션의 가치:
 *    - 컴파일러에게 "이 메서드는 오버라이딩된 것"임을 명시적으로 통보합니다.
 *    - 만약 부모 메서드 이름에 오타(Typos)를 내어 잘못 선언하는 치명적인 실수를 컴파일 에러로 미리 완벽하게 잡아내 줍니다. (Problem 5 연계)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 06 Day 2 학습 예제 ===\n");

        System.out.println("--- Lab1: Animal 클래스 메서드 오버라이딩 (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: toString() 재정의를 통한 인스턴스 정보 로깅 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: equals() 재정의를 통한 논리적 동등성(값) 비교 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: super.메서드() 호출을 이용한 부모 기능의 확장 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: @Override 어노테이션의 중요성 및 컴파일러 안전망 (Problem 5 연계) ---");
        Lab5.run();
    }

    // Problem 1: Animal - Dog - Cat
    static class Animal {
        void sound() {
            System.out.println("동물이 내는 일반적인 소리");
        }
    }

    static class Dog extends Animal {
        @Override
        void sound() {
            System.out.println("멍멍");
        }

        // Problem 4: super.메서드 호출
        void showAndSound() {
            super.sound(); // 부모의 원래 "동물이 내는 일반적인 소리" 호출
            System.out.println("-> [확장] 나는 멍멍 짖는 강아지입니다.");
        }
    }

    static class Cat extends Animal {
        @Override
        void sound() {
            System.out.println("야옹");
        }
    }

    // Problem 2: Book toString
    static class Book {
        String title;
        String author;

        Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return "제목: [" + title + "], 저자: [" + author + "]";
        }
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
            // 1. 동일한 참조 주소인 경우 당연히 동등함
            if (this == obj) return true;
            // 2. null이거나 서로 다른 클래스 타입인 경우 동등할 수 없음
            if (obj == null || getClass() != obj.getClass()) return false;
            // 3. 형변환 후 논리적인 상태 값 비교
            Person p = (Person) obj;
            return age == p.age && Objects.equals(name, p.name);
        }
    }

    static class Lab1 {
        static void run() {
            Animal dog = new Dog();
            Animal cat = new Cat();
            dog.sound();
            cat.sound();
        }
    }

    static class Lab2 {
        static void run() {
            Book book = new Book("자바의 정석", "홍길동");
            // System.out.println에 객체를 직접 던지면 자동으로 toString()이 호출됩니다.
            System.out.println("도서 문자열 표현: " + book);
        }
    }

    static class Lab3 {
        static void run() {
            Person p1 = new Person("홍길동", 20);
            Person p2 = new Person("홍길동", 20);
            Person p3 = new Person("이순신", 45);

            System.out.println("p1.equals(p2) [동일 값 객체]: " + p1.equals(p2));
            System.out.println("p1.equals(p3) [서로 다른 값 객체]: " + p1.equals(p3));
            System.out.println("p1 == p2 [주소값 비교]: " + (p1 == p2) + " (서로 독립된 Heap 객체이므로)");
        }
    }

    static class Lab4 {
        static void run() {
            Dog dog = new Dog();
            dog.showAndSound();
        }
    }

    static class Lab5 {
        static void run() {
            System.out.println("[@Override 어노테이션의 핵심 역할]");
            System.out.println("1. 개발자가 toString() 대신 toStrng()과 같이 오타를 치면, 컴파일러가 '부모에 그런 메서드가 없다'며 즉시 빌드 에러를 냅니다.");
            System.out.println("2. 어노테이션을 생략하면 단순 '새로운 메서드 정의'로 오인되어 런타임에 오버라이딩이 오작동하는 대형 버그로 이어집니다.");
        }
    }
}
