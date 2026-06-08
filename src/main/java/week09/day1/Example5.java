package week09.day1;

/**
 * [학습 예제 5] Week 09 Day 1 — 람다식(Lambda Expression)과 함수형 인터페이스
 * 
 * [문제별 학습 목표]
 * - Lab5: 람다식을 커스텀 인터페이스 변수에 보관 후 반복문 호출 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab5: 람다식을 커스텀 인터페이스 변수에 보관 후 반복문 호출 (Problem 5 연계) ---");
        Lab5.run();
    }

    // Problem 5: 람다식을 보관할 전용 인터페이스 정의
    @FunctionalInterface
    interface Printer {
        void print(String msg);
    }

    static class Lab5 {
        static void run() {
            // Problem 5: 람다식을 인터페이스 변수에 담고, 루프 안에서 3번 호출
            Printer p = msg -> System.out.println("[Printer 출력] " + msg);

            System.out.println("반복문을 시작합니다...");
            for (int i = 1; i <= 3; i++) {
                p.print("반복 카운트: " + i);
            }
        }
    }
}
