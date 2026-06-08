package week02.day1;

/**
 * [학습 예제 1] Week 02 Day 1 — IF 조건문 기초
 * 
 * [학습 핵심 이론: 분기 처리를 위한 if 제어문]
 * 1. 단일 if문:
 *    - 조건식의 결과가 true일 때만 내부 블록의 코드를 실행하고, false이면 건너뜜.
 * 
 * [문제별 학습 목표]
 * - Lab1: 기본 if 문
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: 기본 if 문 ---");
        Lab1.run();
        System.out.println("\n[해설] if 문은 조건식이 true일 때만 내부 블록을 실행합니다.");
    }

    static class Lab1 {
        static void run() {
            int score = 80;
            if (score >= 60) {
                System.out.println("합격입니다!");
            }
        }
    }
}
