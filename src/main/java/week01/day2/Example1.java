package week01.day2;

/**
 * [학습 예제 1] Week 01 Day 2 — 변수와 기본 자료형 및 데이터 특징
 * 
 * [학습 핵심 이론: 변수 선언과 메모리 자료형]
 * 1. 변수(Variable)의 메모리 할당:
 *    - 자료형에 따라 OS는 메모리에 고정된 바이트 크기만큼의 공간을 예약합니다.
 *    - 변수는 이 메모리 번지(Address)의 별칭 역할을 수행합니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: 변수 선언과 값 대입
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: 변수 선언과 값 대입 ---");
        Lab1.run();
        System.out.println("\n[해설] 변수 선언 시 '자료형 변수명 = 값;' 형식을 사용합니다.");
    }

    static class Lab1 {
        static void run() {
            int score; // 선언
            score = 100; // 대입
            System.out.println("점수: " + score);
        }
    }
}
