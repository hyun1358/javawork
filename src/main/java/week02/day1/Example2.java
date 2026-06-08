package week02.day1;

/**
 * [학습 예제 2] Week 02 Day 1 — IF 조건문 기초
 * 
 * [학습 핵심 이론: 분기 처리를 위한 if 제어문]
 * 2. if-else문:
 *    - 조건식이 true일 때와 false일 때 실행할 코드 블록을 확실하게 양자택일로 나눔.
 * 
 * [문제별 학습 목표]
 * - Lab2: if-else 문
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("--- Lab2: if-else 문 ---");
        Lab2.run();
        System.out.println("\n[해설] if-else는 조건이 true면 if 블록을, false면 else 블록을 실행합니다.");
    }

    static class Lab2 {
        static void run() {
            int num = -5;
            if (num >= 0) {
                System.out.println("양수 또는 0입니다.");
            } else {
                System.out.println("음수입니다.");
            }
        }
    }
}
