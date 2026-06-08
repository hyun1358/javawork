package week01.day2;

/**
 * [학습 예제 2] Week 01 Day 2 — 변수와 기본 자료형 및 데이터 특징
 * 
 * [학습 핵심 이론: 변수 선언과 메모리 자료형]
 * 2. 자바의 기본 자료형 (Primitive Types)과 오버플로우:
 *    - 정수형: byte(1B), short(2B), int(4B) - 기본형, long(8B) - 접미사 L 필수.
 *    - **정수 오버플로우(Overflow)**: 변수가 표현할 수 있는 최대 범위를 넘어서면, 가장 최솟값으로 되돌아가 순환하는 현상입니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: 정수형 (int, long) 및 오버플로우
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("--- Lab2: 정수형 (int, long) 및 오버플로우 ---");
        Lab2.run();
        System.out.println("\n[해설] 기본 정수는 int를 사용하지만, 범위를 초과할 시 오버플로우가 나며, 대용량 정수는 long(L 접미사)을 씁니다.");
    }

    static class Lab2 {
        static void run() {
            // int 오버플로우 체험
            int maxInt = 2147483647; // int가 가질 수 있는 최대값
            int overflowed = maxInt + 1; // 최대값에 1을 더함
            System.out.println("int 최대값: " + maxInt);
            System.out.println("최대값 + 1 (오버플로우): " + overflowed); // 최솟값으로 순환됨

            long num2 = 1000000000000L; // 1조 (long 접미사 필수)
            System.out.println("long (1조): " + num2);
        }
    }
}
