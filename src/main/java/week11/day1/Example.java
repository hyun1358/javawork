package week11.day1;

/**
 * [학습 예제] Week 11 Day 1 — 팩토리 메서드 패턴 및 싱글톤 스레드 세이프
 * 
 * [학습 핵심 이론: 인스턴스 생성 제어 디자인 패턴]
 * 1. 싱글톤 패턴 (Singleton Pattern)의 멀티스레드 위협:
 *    - 단순히 `if (instance == null)` 조건으로 구현된 게으른 초기화(Lazy Initialization) 싱글톤은, 동시 다발적인 여러 스레드가 동시에 null 조건을 뚫고 들어오면 힙 영역에 인스턴스가 2개 이상 파생 생성되어 싱글톤 규칙이 깨집니다.
 *    - 이를 해결하기 위해 `synchronized` 동기화 처리를 더하거나, 클래스 로딩 시점에 즉시 할당하는 'Eager Initialization', 혹은 'Bill Pugh Helper Class' 내부 정적 클래스 방식 등을 활용해야 완벽합니다.
 * 
 * 2. 팩토리 메서드 패턴 (Factory Method Pattern):
 *    - 클라이언트 코드가 `new` 연산자로 인스턴스를 직접 구체적으로 찍어내지 않고, 객체 생성을 전담하는 팩토리 클래스나 메서드에게 대행 요청하는 유연한 생성 유틸 패턴입니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab 1: 팩토리를 통한 객체 생성 ===");
        // 직접 new Animal()을 하지 않고 팩토리에게 맡깁니다.
        Animal a1 = AnimalFactory.create("DOG");
        Animal a2 = AnimalFactory.create("CAT");

        a1.speak();
        a2.speak();

        System.out.println("\n=== Lab 2: Synchronized 기반 Thread-Safe 싱글톤 ===");
        LazySingleton instance1 = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();
        System.out.println("두 싱글톤 객체 참조 주소 비교: " + (instance1 == instance2)); // true
    }

    // 스레드 세이프한 싱글톤 예제
    static class LazySingleton {
        private static LazySingleton instance;
        
        private LazySingleton() {}
        
        // synchronized 키워드를 붙여 멀티스레드 환경에서 안전하게 만듭니다.
        public static synchronized LazySingleton getInstance() {
            if (instance == null) {
                instance = new LazySingleton();
            }
            return instance;
        }
    }
}

interface Animal {
    void speak();
}

class Dog implements Animal {
    public void speak() {
        System.out.println("멍멍");
    }
}

class Cat implements Animal {
    public void speak() {
        System.out.println("야옹");
    }
}

class AnimalFactory {
    // 문자열에 따라 적절한 객체를 대신 생성해주는 팩토리
    public static Animal create(String type) {
        if (type.equalsIgnoreCase("DOG")) return new Dog();
        if (type.equalsIgnoreCase("CAT")) return new Cat();
        throw new IllegalArgumentException("알 수 없는 동물 타입");
    }
}
