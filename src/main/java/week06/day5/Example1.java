package week06.day5;

/**
 * [학습 예제 1] Week 06 Day 5 — 인터페이스(Interface)와 다중 구현
 * 
 * [학습 핵심 이론: 인터페이스를 통한 다형성 극대화]
 * 1. 인터페이스 (Interface):
 *    - 극도의 추상화가 적용된 뼈대 설계도로, 오직 '상수(public static final)'와 '추상 메서드(public abstract)'만 멤버로 가질 수 있습니다.
 *    - 클래스처럼 `new` 연산자로 직접 객체를 인스턴스화할 수 없습니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: Flyable 인터페이스 구현 (Bird & Airplane) (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        Flyable bird = new Bird();
        Flyable plane = new Airplane();
        bird.fly();
        plane.fly();
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
}
