package week02.day4;

/**
 * [학습 예제 2] Week 02 Day 4 — while / do-while 반복문 및 루프 제어
 * 
 * [학습 핵심 이론: 조건에 따라 유연하게 반복하는 while 루프]
 * 2. do-while문:
 *    - 일단 루프 바디 코드를 최소 1회 무조건 실행한 뒤, 하단에서 조건식을 검사하여 다음 반복 여부를 판단합니다.
 *    - 사용자 입력 유효성 검사 등 "최소 한 번은 실행해야 하는" 로직에 탁월합니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: do-while 기본 구조
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("--- Lab2: do-while 기본 구조 ---");
        Lab2.run();
        System.out.println("\n[해설] do-while은 본문을 먼저 실행한 후 조건을 검사하므로, 최소 1번은 무조건 실행됩니다.");
    }

    static class Lab2 {
        static void run() {
            int i = 10;
            do {
                System.out.println("일단 실행! i=" + i);
            } while (i < 5);
        }
    }
}
