package week06.day4;

/**
 * [학습 예제] Week 06 Day 4 — 추상 클래스(Abstract Class)와 템플릿 메서드 패턴 (Shape 추상화, Animal 추상/일반 공존, 추상 클래스 객체 생성불가 제약, Beverage-Drink 구현, 요리 시나리오 템플릿 메서드 패턴)
 * 
 * [학습 핵심 이론: 추상 클래스를 통한 표준 설계 규격]
 * 1. 추상 클래스 (Abstract Class, `abstract class`):
 *    - 아직 온전히 완성되지 않은 미완성 설계도입니다.
 *    - 클래스 내부에 실체가 없는 미완성 메서드인 '추상 메서드'를 단 하나라도 가지고 있으면 반드시 클래스도 `abstract`로 선언되어야 합니다.
 *    - 인스턴스화가 완전 차단되므로 `new` 연산자로 직접 객체를 생성할 수 없습니다. (Problem 3 연계)
 * 
 * 2. 추상 메서드 (Abstract Method, `abstract returnType method()`):
 *    - 선언부만 있고 바디(`{ }`)가 없는 메서드로, 자식 클래스에게 해당 메서드를 반드시 재정의(Overriding)해서 완성하도록 강제성을 부여하는 표준 규격서 역할을 합니다. (Problem 1 연계)
 * 
 * 3. 추상과 일반의 공존:
 *    - 추상 클래스는 일반 필드, 일반 메서드, 생성자를 가질 수 있어 공통 기능은 직접 구현하고 개별 가공이 필요한 기능만 추상화할 수 있습니다. (Problem 2, 4 연계)
 * 
 * 4. 템플릿 메서드 패턴 (Template Method Pattern):
 *    - 변하지 않는 전체 실행 프로세스(알고리즘 골격)는 부모 추상 클래스 내에 `final` 일반 메서드로 확정해 두고, 중간에 들어갈 가변 세부 로직만 추상 메서드로 자식에게 위임하는 실무 디자인 패턴입니다. (Problem 5 연계)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 06 Day 4 학습 예제 ===\n");

        System.out.println("--- Lab1: 추상 클래스 Shape 설계 및 Circle / Rectangle 구현 (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: 추상 클래스 Animal 내의 추상/일반 메서드 공존 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: 추상 클래스의 인스턴스 생성 불가 제약사항 검증 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: Beverage 추상 클래스와 Drink 자식 클래스의 규격 구현 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: 템플릿 메서드 패턴을 이용한 일관된 요리(Food) 조리 흐름 제어 (Problem 5 연계) ---");
        Lab5.run();

        System.out.println("\n--- Lab6: 커피 제조 프로세스(CoffeeMaker) 템플릿 메서드 패턴 예시 ---");
        Lab6.run();
    }

    // Problem 1: Shape 추상화
    static abstract class Shape {
        abstract double area(); // 자식들에게 무조건 구체적 면적 계산 수식을 구현하게 강제함
    }

    static class Circle extends Shape {
        int radius;
        Circle(int radius) { this.radius = radius; }

        @Override
        double area() {
            return radius * radius * Math.PI;
        }
    }

    static class Rectangle extends Shape {
        int width, height;
        Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        double area() {
            return width * height;
        }
    }

    // Problem 2: Animal 추상/일반 공존
    static abstract class Animal {
        abstract void sound(); // 추상 메서드 (자식이 오버라이딩 강제)

        void breathe() { // 일반 메서드 (공통 코드 제공)
            System.out.println("생명체가 코로 공기를 빨아들여 조용히 숨을 쉽니다.");
        }
    }

    static class Dog extends Animal {
        @Override
        void sound() {
            System.out.println("멍멍!");
        }
    }

    // Problem 4: Beverage - Drink
    static abstract class Beverage {
        abstract void brew(); // 우려내는 방식 (추상)

        void serve() { // 서빙 방식 (공통)
            System.out.println("손님에게 음료를 예쁜 컵에 담아 제공합니다.");
        }
    }

    static class Drink extends Beverage {
        @Override
        void brew() {
            System.out.println("유기농 찻잎을 80도 따뜻한 물에 천천히 우려냅니다.");
        }
    }

    // Problem 5: Food 요리 템플릿 메서드 패턴
    static abstract class Food {
        // 공통 스텝 1
        void clean() {
            System.out.println("1단계: 신선한 재료를 흐르는 물에 깨끗이 세척합니다.");
        }

        // 공통 스텝 2
        void trim() {
            System.out.println("2단계: 용도에 맞게 칼로 재료를 알맞게 손질합니다.");
        }

        // 가변 스텝 3 (추상 메서드로 오버라이딩 유도)
        abstract void cook();

        // 공통 스텝 4
        void plate() {
            System.out.println("4단계: 음식을 완성 접시에 보기 좋게 담아 올립니다.");
        }

        // 템플릿 메서드: 전체 알고리즘 뼈대 (흐름을 바꿀 수 없도록 final 선언)
        public final void order() {
            clean();
            trim();
            cook();
            plate();
        }
    }

    static class Tteokbokki extends Food {
        @Override
        void cook() {
            System.out.println("3단계 [떡볶이 조리]: 밀떡을 매콤달콤한 비법 고추장 양념에 잘 버무려 졸이듯 끓입니다.");
        }
    }

    // Lab6: Coffee 템플릿 예시
    static abstract class CoffeeMaker {
        public final void makeCoffee() {
            boilWater();
            brew();
            pour();
        }
        void boilWater() { System.out.println("물을 100도씨로 팔팔 끓입니다."); }
        abstract void brew();
        void pour() { System.out.println("끓인 물과 에스프레소를 컵에 부어 섞습니다."); }
    }

    static class AmericanoMaker extends CoffeeMaker {
        @Override
        void brew() {
            System.out.println("강하게 볶은 아라비카 원두로부터 에스프레소 샷을 고압 추출합니다.");
        }
    }

    static class Lab1 {
        static void run() {
            Shape c = new Circle(3);
            Shape r = new Rectangle(3, 5);
            System.out.printf("원 넓이(반지름 3): %.2f\n", c.area());
            System.out.printf("사각형 넓이(3x5): %.2f\n", r.area());
        }
    }

    static class Lab2 {
        static void run() {
            Animal dog = new Dog();
            dog.breathe(); // 일반 메서드
            dog.sound();   // 오버라이딩된 추상 메서드
        }
    }

    static class Lab3 {
        static void run() {
            // Animal ani = new Animal(); // [컴파일 에러!] 'Animal is abstract; cannot be instantiated'
            System.out.println("[추상 클래스 인스턴스화 차단]");
            System.out.println("-> 추상 클래스는 본체에 구현되지 않은 빈 껍데기(추상 메서드)가 섞여 있어 불완전하므로 직접 new 할 수 없습니다.");
        }
    }

    static class Lab4 {
        static void run() {
            Beverage tea = new Drink();
            tea.brew();
            tea.serve();
        }
    }

    static class Lab5 {
        static void run() {
            Food food = new Tteokbokki();
            System.out.println("--- 떡볶이 요리 프로세스 가동 ---");
            food.order(); // 일관된 프로세스대로 실행됨을 검증
        }
    }

    static class Lab6 {
        static void run() {
            CoffeeMaker maker = new AmericanoMaker();
            maker.makeCoffee();
        }
    }
}
