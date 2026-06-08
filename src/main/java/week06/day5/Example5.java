package week06.day5;

/**
 * [학습 예제 5] Week 06 Day 5 — 인터페이스(Interface)와 다중 구현
 * 
 * [학습 핵심 이론: 인터페이스를 통한 다형성 극대화]
 * 4. 인터페이스 다형성:
 *    - 인터페이스 또한 부모 타입 참조 변수로 활용할 수 있어, 동일한 인터페이스를 구현한 이종(異種) 클래스 객체들을 하나의 인터페이스 배열로 묶어 일괄 조작할 수 있습니다.
 * 
 * [문제별 학습 목표]
 * - Lab5: Flyable 인터페이스 다형성 배열의 일괄 비행 통제 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        Flyable[] squadron = {
            new Duck(),
            new Airplane(),
            new Bird()
        };
        for (Flyable f : squadron) {
            f.fly(); // 인터페이스 다형성 배열 제어
        }
    }

    interface Flyable {
        void fly();
    }

    static class Duck implements Flyable {
        @Override
        public void fly() {
            System.out.println("오리가 넓은 날개를 퍼덕이며 낮게 비행합니다.");
        }
    }

    static class Airplane implements Flyable {
        @Override
        public void fly() {
            System.out.println("비행기가 엄청난 추진력의 제트 엔진을 분사하여 구름 위를 날아갑니다.");
        }
    }

    static class Bird implements Flyable {
        @Override
        public void fly() {
            System.out.println("새가 날개를 힘차게 퍼덕이며 파란 하늘을 자유롭게 날아갑니다.");
        }
    }
}
