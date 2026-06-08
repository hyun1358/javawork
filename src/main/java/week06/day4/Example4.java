package week06.day4;

/**
 * [학습 예제 4] Week 06 Day 4 — 추상 클래스(Abstract Class)와 템플릿 메서드 패턴
 * 
 * [학습 핵심 이론: 추상 클래스를 통한 표준 설계 규격]
 * 3. 추상과 일반의 공존:
 *    - 추상 클래스는 일반 필드, 일반 메서드, 생성자를 가질 수 있어 공통 기능은 직접 구현하고 개별 가공이 필요한 기능만 추상화할 수 있습니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: Beverage 추상 클래스와 Drink 자식 클래스의 규격 구현 (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        Beverage tea = new Drink();
        tea.brew();
        tea.serve();
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
}
