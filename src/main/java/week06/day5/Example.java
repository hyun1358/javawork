package week06.day5;

/**
 * [학습 예제] Week 06 Day 5 — 인터페이스(Interface)와 다중 구현 (Flyable 비행, Swimeable-Flyable 다중 구현 Duck, Printable 일괄 출력, Machine 디폴트 전원제어, Flyable 다형성 배열)
 * 
 * [학습 핵심 이론: 인터페이스를 통한 다형성 극대화]
 * 1. 인터페이스 (Interface):
 *    - 극도의 추상화가 적용된 뼈대 설계도로, 오직 '상수(public static final)'와 '추상 메서드(public abstract)'만 멤버로 가질 수 있습니다. (JDK 8 이후 default/static 메서드 추가 허용)
 *    - 클래스처럼 `new` 연산자로 직접 객체를 인스턴스화할 수 없습니다.
 * 
 * 2. 다중 구현 (Multiple Implementation):
 *    - 자바는 클래스 간 단일 상속만 허용하여 복잡성과 꼬임 문제를 막는 대신, 인터페이스 다중 구현(`implements A, B`)을 완벽히 허용하여 느슨한 결합(Loose Coupling)과 대안적 다중 상속을 실현합니다. (Problem 2 연계)
 * 
 * 3. 디폴트 메서드 (Default Method):
 *    - `default` 키워드를 붙여 인터페이스 내부에도 실행 코드 바디(`{ }`)를 가질 수 있습니다.
 *    - 이를 구현한 기존 클래스들에 하위 호환성 충돌 없이 새로운 공통 기능을 일괄 추가/확장할 수 있어 실무 설계에서 유용하게 쓰입니다. (Problem 4 연계)
 * 
 * 4. 인터페이스 다형성:
 *    - 인터페이스 또한 부모 타입 참조 변수로 활용할 수 있어, 동일한 인터페이스를 구현한 이종(異種) 클래스 객체들을 하나의 인터페이스 배열로 묶어 일괄 조작할 수 있습니다. (Problem 3, 5 연계)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 06 Day 5 학습 예제 ===\n");

        System.out.println("--- Lab1: Flyable 인터페이스 구현 (Bird & Airplane) (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: 인터페이스 다중 구현을 만족하는 Duck 클래스 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: Printable 규격을 만족하는 문서와 사진 일괄 출력 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: Machine 인터페이스의 default 전원 제어 기능 활용 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: Flyable 인터페이스 다형성 배열의 일괄 비행 통제 (Problem 5 연계) ---");
        Lab5.run();
    }

    // Problem 1: Flyable 인터페이스와 구현 클래스들
    interface Flyable {
        void fly(); // 암묵적으로 public abstract void fly() 입니다.
    }

    static class Bird implements Flyable {
        @Override
        public void fly() { // 중요: 오버라이딩 시 public을 생략하거나 줄일 수 없습니다.
            System.out.println("새가 날개를 힘차게 퍼덕이며 파란 하늘을 자유롭게 날아갑니다.");
        }
    }

    static class Airplane implements Flyable {
        @Override
        public void fly() {
            System.out.println("비행기가 엄청난 추진력의 제트 엔진을 분사하여 구름 위를 날아갑니다.");
        }
    }

    // Problem 2: Swimeable 인터페이스와 다중 구현 Duck
    interface Swimeable {
        void swim();
    }

    // Swimeable과 Flyable을 동시 다중 구현
    static class Duck implements Swimeable, Flyable {
        @Override
        public void swim() {
            System.out.println("오리가 둥근 물갈퀴 발을 저으며 물속을 평화롭게 헤엄칩니다.");
        }

        @Override
        public void fly() {
            System.out.println("오리가 넓은 날개를 퍼덕이며 낮게 비행합니다.");
        }
    }

    // Problem 3: Printable 인터페이스와 구현체
    interface Printable {
        void print();
    }

    static class Document implements Printable {
        @Override
        public void print() {
            System.out.println("[문서 출력] 작성된 보고서 텍스트 문서 데이터를 A4 용지에 잉크로 인쇄합니다.");
        }
    }

    static class Photo implements Printable {
        @Override
        public void print() {
            System.out.println("[사진 출력] 고해상도 풍경 이미지 데이터를 광택 사진 전용지에 세밀하게 인쇄합니다.");
        }
    }

    // Problem 4: Machine 인터페이스와 default 메서드
    interface Machine {
        // default 구현 메서드 1
        default void powerOn() {
            System.out.println("기계의 메인 전원을 켭니다. (부팅 완료)");
        }

        // default 구현 메서드 2
        default void powerOff() {
            System.out.println("기계의 전원을 차단합니다. (시스템 정상 종료)");
        }

        void print(); // 일반 추상 메서드
    }

    static class SmartPrinter implements Machine {
        @Override
        public void print() {
            System.out.println("스마트 프린터가 결과물을 정밀 인쇄 출력하는 중입니다.");
        }
    }

    static class Lab1 {
        static void run() {
            Flyable bird = new Bird();
            Flyable plane = new Airplane();
            bird.fly();
            plane.fly();
        }
    }

    static class Lab2 {
        static void run() {
            Duck duck = new Duck();
            duck.swim();
            duck.fly();
        }
    }

    static class Lab3 {
        static void run() {
            Printable[] queue = {
                new Document(),
                new Photo(),
                new Document()
            };
            for (Printable p : queue) {
                p.print(); // 일관된 출력 규격 조작
            }
        }
    }

    static class Lab4 {
        static void run() {
            SmartPrinter sp = new SmartPrinter();
            sp.powerOn();  // default 메서드 바로 호출 가능
            sp.print();    // 구현 메서드 호출
            sp.powerOff(); // default 메서드 바로 호출 가능
        }
    }

    static class Lab5 {
        static void run() {
            Flyable[] squadron = {
                new Duck(),
                new Airplane(),
                new Bird()
            };
            for (Flyable f : squadron) {
                f.fly(); // 인터페이스 다형성 배열 제어
            }
        }
    }
}
