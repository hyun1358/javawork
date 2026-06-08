package week01.day3;

/**
 * [학습 예제 1] Week 01 Day 3 — 연산자 종합
 * 
 * [학습 핵심 이론: 자바의 연산자 체계]
 * 1. 산술 연산자 (Arithmetic Operators):
 *    - +, -, *, /, % (나머지 연산자)
 *    - 정수 간의 나눗셈(/)은 소수점을 절삭한 정수 몫만 반환하며, 실수 연산은 소수점 이하까지 정밀하게 계산합니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: 산술 연산자 (+, -, *, /, %)
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: 산술 연산자 (+, -, *, /, %) ---");
        Lab1.run();
        System.out.println("\n[해설] /는 몫을, %는 나머지를 구합니다. 정수끼리의 계산 결과는 정수입니다.");
    }

    static class Lab1 {
        static void run() {
            int x = 10, y = 3;
            System.out.println("x + y = " + (x + y));
            System.out.println("x / y = " + (x / y));
            System.out.println("x % y = " + (x % y));
        }
    }
}
