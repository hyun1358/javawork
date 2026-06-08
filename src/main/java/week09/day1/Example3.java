package week09.day1;

/**
 * [학습 예제 3] Week 09 Day 1 — 람다식(Lambda Expression)과 함수형 인터페이스
 * 
 * [학습 핵심 이론: 자바의 함수형 프로그래밍 지원 - 람다]
 * 2. 람다식 (Lambda Expression, `(parameters) -> { body }`):
 *    - 익명 클래스의 불필요한 보일러플레이트 코드(메서드명 선언 등)를 걷어내고, 메서드를 하나의 간결한 '식(Expression)'으로 표현한 익명 함수입니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: 익명 클래스 vs 람다식 Runnable 생성 및 동작 (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab3: 익명 클래스 vs 람다식 Runnable 생성 및 동작 (Problem 3 연계) ---");
        Lab3.run();
    }

    static class Lab3 {
        static void run() {
            // Problem 3: Runnable 람다
            // 1. 기존의 지저분한 익명 클래스 방식
            Runnable runnableOld = new Runnable() {
                @Override
                public void run() {
                    System.out.println("[익명 클래스] Hello Old Java!");
                }
            };
            runnableOld.run();

            // 2. 현대적이고 가독성 높은 람다식 방식
            Runnable runnableNew = () -> System.out.println("[람다식 방식] Hello Lambda!");
            runnableNew.run();
        }
    }
}
