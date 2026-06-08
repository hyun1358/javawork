package week03.day1;

/**
 * [학습 예제 1] Week 03 Day 1 — 1차원 배열 기초
 * 
 * [학습 핵심 이론: 순차 데이터 구조 - 배열]
 * 1. 배열(Array)의 메모리 특징:
 *    - 같은 타입의 변수들을 연속된 메모리 공간에 나열한 고정 크기 자료구조입니다.
 *    - 선언 시 크기가 고정되며, 런타임에 동적으로 크기를 늘리거나 줄일 수 없습니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: 배열 선언과 생성
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: 배열 선언과 생성 ---");
        Lab1.run();
    }

    static class Lab1 {
        static void run() {
            // 크기 3의 int 배열 생성 (0으로 자동 초기화됨)
            int[] arr = new int[3];
            System.out.println("arr[0]: " + arr[0]); 
            System.out.println("arr[1]: " + arr[1]); 
        }
    }
}
