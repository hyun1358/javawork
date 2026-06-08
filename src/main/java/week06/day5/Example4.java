package week06.day5;

/**
 * [학습 예제 4] Week 06 Day 5 — 인터페이스(Interface)와 다중 구현
 * 
 * [학습 핵심 이론: 인터페이스를 통한 다형성 극대화]
 * 3. 디폴트 메서드 (Default Method):
 *    - `default` 키워드를 붙여 인터페이스 내부에도 실행 코드 바디(`{ }`)를 가질 수 있습니다.
 *    - 이를 구현한 기존 클래스들에 하위 호환성 충돌 없이 새로운 공통 기능을 일괄 추가/확장할 수 있어 실무 설계에서 유용하게 쓰입니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: Machine 인터페이스의 default 전원 제어 기능 활용 (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        SmartPrinter sp = new SmartPrinter();
        sp.powerOn();  // default 메서드 바로 호출 가능
        sp.print();    // 구현 메서드 호출
        sp.powerOff(); // default 메서드 바로 호출 가능
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
}
