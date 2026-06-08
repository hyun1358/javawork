package week02.day4;

/**
 * [학습 예제 1] Week 02 Day 4 — while / do-while 반복문 및 루프 제어
 * 
 * [학습 핵심 이론: 조건에 따라 유연하게 반복하는 while 루프]
 * 1. while문:
 *    - 반복 횟수를 예측하기 어렵고, 특정 조건이 true로 유지되는 동안 무한히 반복할 때 사용합니다.
 *    - 루프 진입 전 조건식을 먼저 검사하므로, 조건이 처음부터 false이면 내부 코드가 단 한 번도 실행되지 않습니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: while 기본 구조
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: while 기본 구조 ---");
        Lab1.run();
        System.out.println("\n[해설] while은 조건식이 true인 동안 계속 반복합니다. 블록 안에서 조건을 바꿀 증감식이 꼭 필요합니다.");
    }

    static class Lab1 {
        static void run() {
            int i = 1;
            while (i <= 3) {
                System.out.println("반복 중: " + i);
                i++;
            }
        }
    }
}
