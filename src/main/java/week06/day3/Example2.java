package week06.day3;

/**
 * [학습 예제 2] Week 06 Day 3 — 다형성(Polymorphism)의 심화
 * 
 * [학습 핵심 이론: 다형적 형변환과 런타임 바인딩]
 * 2. 동적 바인딩 (Dynamic Binding):
 *    - 부모 타입 참조 변수로 오버라이딩된 메서드를 호출하면, 컴파일러가 부모 메서드를 바라보더라도 런타임에 JVM이 힙 메모리에 적재된 실제 자식 객체의 오버라이딩된 메서드를 찾아 실행합니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: 부모 변수를 통한 자식 오버라이딩 메서드 호출 (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        Parents p = new Child(); // 업캐스팅
        p.info(); // 런타임에 실제 객체인 Child의 info()가 호출됨 (동적 바인딩)
    }

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
    }
}
