package week02.day3;

/**
 * [학습 예제 1] Week 02 Day 3 — for 반복문 기초
 * 
 * [학습 핵심 이론: 반복 횟수가 명확할 때 쓰는 for 루프]
 * 1. for문의 3단계 구성 요소:
 *    - 초기화식: 반복문이 시작할 때 딱 한 번 실행되며 반복용 변수를 선언 및 초기화합니다.
 *    - 조건식: 루프를 실행하기 전 조건을 검사하여 true이면 실행하고 false이면 루프를 종료합니다.
 *    - 증감식: 루프 내부 바디가 한 번 끝날 때마다 실행되어 루프 제어 변수의 상태를 업데이트합니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: 기본 for 문 구조
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: 기본 for 문 구조 ---");
        Lab1.run();
        System.out.println("\n[해설] for(초기화; 조건식; 증감식) 순서로 작동합니다.");
    }

    static class Lab1 {
        static void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("안녕하세요 " + i);
            }
        }
    }
}
