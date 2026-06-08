package week03.day1;

/**
 * [학습 예제 2] Week 03 Day 1 — 1차원 배열 기초
 * 
 * [학습 핵심 이론: 순차 데이터 구조 - 배열]
 * 2. 힙(Heap) 메모리 할당:
 *    - 배열 변수는 참조 타입으로, 실제 데이터는 힙(Heap) 메모리에 생성되고 변수(Stack)는 그 주소값만 보관합니다.
 *    - 초기화를 생략하면 각 자료형의 기본값(정수: 0, 실수: 0.0, 참조형: null)으로 자동 세팅됩니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: 배열 초기화 ({} 사용)
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab2: 배열 초기화 ({} 사용) ---");
        Lab2.run();
    }

    static class Lab2 {
        static void run() {
            // 선언과 동시에 중괄호 {}를 사용해 초기화
            int[] scores = {10, 20, 30, 40, 50};
            System.out.println("첫 번째 값: " + scores[0]);
            System.out.println("세 번째 값: " + scores[2]);
        }
    }
}
