package week02.day3;

/**
 * [학습 예제 2] Week 02 Day 3 — for 반복문 기초
 * 
 * [학습 핵심 이론: 반복 횟수가 명확할 때 쓰는 for 루프]
 * [문제별 학습 목표]
 * - Lab2: 1~N 합계 구하기
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("--- Lab2: 1~N 합계 구하기 ---");
        Lab2.run();
        System.out.println("\n[해설] 반복문 밖에서 변수를 선언하고, 안에서 누적시키는 패턴을 기억하세요.");
    }

    static class Lab2 {
        static void run() {
            int n = 100;
            int total = 0;
            for (int i = 1; i <= n; i++) {
                total += i;
            }
            System.out.println("1부터 " + n + "까지의 합: " + total);
        }
    }
}
