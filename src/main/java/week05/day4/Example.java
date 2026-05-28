package week05.day4;

/**
 * [학습 예제] Week 05 Day 4 — static과 메모리 구조 (Circle 카운터, MyMath 유틸리티, static 제약 조건, static 초기화 블록, 싱글톤 패턴)
 * 
 * [학습 핵심 이론: static 키워드와 클래스 멤버]
 * 1. static 변수 (정적 변수 / 클래스 변수):
 *    - 클래스가 메모리(Method Area)에 로딩될 때 딱 한 번 할당되며, 해당 클래스로 생성된 모든 인스턴스가 공간을 공유합니다. (Problem 1 연계)
 * 
 * 2. static 메서드 (정적 메서드):
 *    - 객체 생성(new) 없이 클래스 이름으로 직접 호출 가능합니다.
 *    - 상태값을 유지하지 않는 순수 계산용 유틸리티에 적합합니다. (Problem 2 연계)
 * 
 * 3. static의 제약 조건:
 *    - static 멤버는 인스턴스가 생성되기 전에 이미 메모리에 올라가므로, 아직 메모리에 생성되지 않았을 수 있는 인스턴스 멤버(필드, 메서드)에 직접 접근할 수 없습니다. (Problem 3 연계)
 * 
 * 4. static 초기화 블록 (`static { }`):
 *    - 클래스가 최초로 메모리에 로드될 때 실행되며, 복잡한 static 필드 초기화에 적합합니다. (Problem 4 연계)
 * 
 * 5. 싱글톤 패턴 (Singleton Pattern):
 *    - 시스템 전체에서 단 하나의 인스턴스만 보장하도록 하는 핵심 디자인 패턴입니다. (Problem 5 연계)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 05 Day 4 학습 예제 ===\n");

        System.out.println("--- Lab1: static 필드를 이용한 객체 카운터 (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: static 메서드로 구성된 수학 유틸리티 클래스 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: static 메서드 내부에서 인스턴스 자원 접근 제약 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: 클래스 최초 로드 시 실행되는 static 초기화 블록 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: 싱글톤(Singleton) 패턴의 올바른 설계 및 테스트 (Problem 5 연계) ---");
        Lab5.run();
    }

    // Problem 1: Circle 클래스 정의 (static 카운터)
    static class Circle {
        static int count = 0; // 모든 Circle 객체가 공유하는 정적 변수

        Circle() {
            count++;
            System.out.println("[객체 생성] 새로운 원이 생성되었습니다. (현재 누적 개수: " + count + ")");
        }
    }

    // Problem 2: MyMath 클래스 정의 (정적 유틸리티)
    static class MyMath {
        // 객체 생성 없이 사용하는 static abs 메서드
        public static int abs(int n) {
            return n < 0 ? -n : n;
        }
    }

    // Problem 3: static 제약 조건을 보여주기 위한 멤버
    int instanceValue = 10; // 인스턴스 변수

    // Problem 4: static 초기화 블록 클래스
    static class TestClass {
        static {
            System.out.println("[static 블록] TestClass가 JVM에 처음 로드되었습니다. (한 번만 출력됨)");
        }

        TestClass() {
            System.out.println("[생성자] TestClass 인스턴스가 생성되었습니다.");
        }
    }

    // Problem 5: Singleton 패턴 구현
    static class Singleton {
        // 1. 클래스 로드 시점에 단 하나의 인스턴스를 static 영역에 미리 생성
        private static final Singleton INSTANCE = new Singleton();

        // 2. 생성자를 private으로 통제하여 외부에서 new 호출을 차단
        private Singleton() {
            System.out.println("-> 싱글톤 인스턴스가 생성되었습니다.");
        }

        // 3. 외부에서는 오직 이 static 메서드를 통해서만 공유 인스턴스를 가져가게 함
        public static Singleton getInstance() {
            return INSTANCE;
        }
    }

    static class Lab1 {
        static void run() {
            Circle.count = 0; // 테스트 전 초기화
            new Circle();
            new Circle();
            new Circle();
            System.out.println("최종 생성된 원의 개수: " + Circle.count);
        }
    }

    static class Lab2 {
        static void run() {
            int result = MyMath.abs(-7);
            System.out.println("MyMath.abs(-7) 결과: " + result);
        }
    }

    static class Lab3 {
        static void run() {
            // System.out.println(instanceValue); // [컴파일 에러!] static 메서드 run()에서는 non-static 필드인 instanceValue를 직접 참조할 수 없습니다.
            System.out.println("[해설] static 메서드는 인스턴스화 이전에 로드되므로 인스턴스 변수(non-static)를 인식할 수 없습니다.");
            System.out.println("[해결책] 다음과 같이 객체를 먼저 명시적으로 생성하여 접근해야 합니다:");
            
            Example ex = new Example();
            System.out.println("-> 객체 생성 후 접근한 인스턴스 값: " + ex.instanceValue);
        }
    }

    static class Lab4 {
        static void run() {
            System.out.println("--- 첫 번째 객체 생성 시도 ---");
            TestClass t1 = new TestClass();

            System.out.println("\n--- 두 번째 객체 생성 시도 ---");
            TestClass t2 = new TestClass(); // static 블록은 재실행되지 않음을 확인!
        }
    }

    static class Lab5 {
        static void run() {
            // Singleton s = new Singleton(); // [컴파일 에러!] private 생성자이므로 직접 new 생성 차단됨

            Singleton s1 = Singleton.getInstance();
            Singleton s2 = Singleton.getInstance();

            System.out.println("s1의 주소: " + s1);
            System.out.println("s2의 주소: " + s2);

            if (s1 == s2) {
                System.out.println("결과: 두 변수는 물리적으로 완벽히 동일한 메모리 주소를 가리킵니다. (싱글톤 성공)");
            }
        }
    }
}
