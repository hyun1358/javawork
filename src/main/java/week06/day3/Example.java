package week06.day3;

/**
 * [학습 예제] Week 06 Day 3 — 다형성(Polymorphism)의 심화 (Shape 다형성 배열, 부모 타입 메서드 결정, instanceof 다운캐스팅, ClassCastException 예외, 다형적 급여 계산)
 * 
 * [학습 핵심 이론: 다형적 형변환과 런타임 바인딩]
 * 1. 업캐스팅 (Upcasting)과 다형성 배열:
 *    - 자식 객체의 주소값을 부모 타입 참조 변수에 담는 행위입니다. (자동 형변환 지원)
 *    - 공통 조상 타입의 배열(`Shape[]` 또는 `Employee[]`)을 선언하면 각기 다른 자식 인스턴스들을 일관되게 묶어 일괄 루프로 처리할 수 있어 확장성이 극대화됩니다. (Problem 1, 5 연계)
 * 
 * 2. 동적 바인딩 (Dynamic Binding):
 *    - 부모 타입 참조 변수로 오버라이딩된 메서드를 호출하면, 컴파일러가 부모 메서드를 바라보더라도 런타임에 JVM이 힙 메모리에 적재된 실제 자식 객체의 오버라이딩된 메서드를 찾아 실행합니다. (Problem 2 연계)
 * 
 * 3. 다운캐스팅 (Downcasting)과 instanceof 안전 장치:
 *    - 부모 타입 참조 변수를 자식 고유의 속성/메서드를 사용하기 위해 다시 자식 타입으로 돌려놓는 수동 형변환입니다.
 *    - 힙의 실제 객체가 해당 자식 타입이 아닐 때 다운캐스팅하면 `ClassCastException`이 일어나며 프로그램이 크래시됩니다. (Problem 4 연계)
 *    - 항상 `instanceof` 연산자로 힙 인스턴스 형식을 확인한 뒤 캐스팅을 실행하는 것이 철칙입니다. (Problem 3 연계)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 06 Day 3 학습 예제 ===\n");

        System.out.println("--- Lab1: Shape 다형성 배열과 일괄 면적 출력 (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: 부모 변수를 통한 자식 오버라이딩 메서드 호출 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: instanceof 안전망을 이용한 안정적인 다운캐스팅 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: 잘못된 형변환 시 발생하는 ClassCastException 실습 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: 다형성을 이용한 전사 급여(Employee) 총합 계산기 (Problem 5 연계) ---");
        Lab5.run();
    }

    // Problem 1: Shape 계층 정의
    static class Shape {
        void extent() {
            System.out.println("도형의 넓이를 계산합니다.");
        }
    }

    static class Circle extends Shape {
        int radius;
        Circle(int radius) { this.radius = radius; }

        @Override
        void extent() {
            System.out.println("원 넓이: " + (radius * radius * 3.14));
        }
    }

    static class Rectangle extends Shape {
        int width, height;
        Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        void extent() {
            System.out.println("사각형 넓이: " + (width * height));
        }
    }

    // Problem 2, 3, 4: Parents & Child
    static class Parents {
        void info() {
            System.out.println("나는 부모입니다.");
        }
    }

    static class Child extends Parents {
        @Override
        void info() {
            System.out.println("나는 자식입니다.");
        }

        void childSpecial() {
            System.out.println("-> [자식 전용 기능] 자식 고유의 특수한 메서드를 실행합니다.");
        }
    }

    // Problem 5: Employee 계층
    static class Employee {
        int money;
        int getMoney() { return money; }
    }

    static class Manager extends Employee {
        Manager(int money) { this.money = money; }
    }

    static class Developer extends Employee {
        Developer(int money) { this.money = money; }
    }

    static class Lab1 {
        static void run() {
            Shape[] shapes = {
                new Circle(5),
                new Rectangle(5, 10),
                new Circle(7),
                new Rectangle(3, 5)
            };
            for (Shape s : shapes) {
                s.extent(); // 다형적 메서드 호출
            }
        }
    }

    static class Lab2 {
        static void run() {
            Parents p = new Child(); // 업캐스팅
            p.info(); // 런타임에 실제 객체인 Child의 info()가 호출됨 (동적 바인딩)
        }
    }

    static class Lab3 {
        static void run() {
            Parents p = new Child();
            
            // instanceof 안전하게 검증
            if (p instanceof Child) {
                Child c = (Child) p; // 안전한 다운캐스팅
                c.childSpecial();    // 자식 고유 메서드 호출 성공
            } else {
                System.out.println("Child 객체가 아니므로 다운캐스팅 불가");
            }
        }
    }

    static class Lab4 {
        static void run() {
            Parents p = new Parents(); // 실제 힙 객체가 부모임
            
            try {
                System.out.println("의도적으로 잘못된 다운캐스팅을 시도합니다...");
                Child c = (Child) p; // ClassCastException 발생!
                c.childSpecial();
            } catch (ClassCastException e) {
                System.out.println("예외 포착 성공: " + e.toString());
                System.out.println("-> [해설] 힙 객체(Parents)는 자식의 메모리 구조를 갖추지 않았으므로 강제 형변환하면 다운됩니다.");
            }
        }
    }

    static class Lab5 {
        static void run() {
            Employee[] team = {
                new Manager(15000),
                new Developer(20000),
                new Manager(25000),
                new Developer(50000)
            };

            int totalSalary = 0;
            for (Employee e : team) {
                totalSalary += e.getMoney();
            }
            System.out.println("우리 팀의 전체 급여 지출액 합계: " + totalSalary + "원");
        }
    }
}
