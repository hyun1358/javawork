package week01.day4;

/**
 * [학습 예제 1] Week 01 Day 4 — 형변환 (Casting)과 데이터 파싱
 * 
 * [학습 핵심 이론: 데이터 타입 변환 매커니즘]
 * 1. 자동 형변환 (Implicit Casting / Promotion):
 *    - 작은 크기의 타입에서 큰 크기의 타입으로 데이터가 이동할 때 자동으로 일어납니다.
 *    - 값의 손실이 없기 때문에 컴파일러가 스스로 처리해 줍니다. (예: int -> double)
 * 
 * [문제별 학습 목표]
 * - Lab1: 자동 형변환
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: 자동 형변환 ---");
        Lab1.run();
        System.out.println("\n[해설] 데이터 손실이 없는 경우 자바가 알아서 바꿔줍니다.");
    }

    static class Lab1 {
        static void run() {
            int i = 100;
            long l = i;
            double d = l;
            System.out.println("int -> long -> double: " + d);
        }
    }
}
