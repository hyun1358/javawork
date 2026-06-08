package week06.day1;

/**
 * [학습 예제 5] Week 06 Day 1 — 객체지향 상속(Inheritance)과 super
 * 
 * [학습 핵심 이론: 객체지향의 상속 매커니즘]
 * 3. 3단계 다층 상속 (Multi-level Inheritance):
 *    - A -> B -> C와 같은 형태의 수직 다층 상속 구조는 완벽히 허용하며, 최하위 클래스 C의 객체는 A와 B의 필드/메서드를 모두 사용할 수 있습니다.
 * 
 * [문제별 학습 목표]
 * - Lab5: A -> B -> C 3단계 수직 상속 계층 동작 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        C obj = new C();
        obj.methodA(); // A에서 상속
        obj.methodB(); // B에서 상속
        obj.methodC(); // C 자체 선언
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
}
