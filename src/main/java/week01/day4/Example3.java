package week01.day4;

/**
 * [학습 예제 3] Week 01 Day 4 — 형변환 (Casting)과 데이터 파싱
 * 
 * [학습 핵심 이론: 데이터 타입 변환 매커니즘]
 * [문제별 학습 목표]
 * - Lab3: 정수 나눗셈의 함정
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("--- Lab3: 정수 나눗셈의 함정 ---");
        Lab3.run();
        System.out.println("\n[해설] 정수/정수는 정수입니다. 실수를 얻으려면 한쪽을 실수로 바꿔야 합니다.");
    }

    static class Lab3 {
        static void run() {
            int a = 7, b = 2;
            System.out.println("7 / 2 그냥 계산: " + (a / b));
            System.out.println("7 / 2 형변환 계산: " + ((double) a / b));
        }
    }
}
