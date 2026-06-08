package week03.day5;

/**
 * [학습 예제 2] Week 03 Day 5 — Math API와 난수 생성
 * 
 * [학습 핵심 이론: Math 클래스와 난수(Random) 활용]
 * 1. Math.random():
 *    - 예 (1~6 주사위): `(int) (Math.random() * 6) + 1`
 * 
 * [문제별 학습 목표]
 * - Lab2: 주사위 10회 통계 및 합계 (Problem 2 연계)
 */
import java.util.Arrays;

public class Example2 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab2: 주사위 10회 통계 및 합계 (Problem 2 연계) ---");
        Lab2.run();
    }

    static class Lab2 {
        static void run() {
            // Problem 2: 주사위(1~6)를 10번 굴려 나온 숫자들을 배열에 저장하고 합계 산출
            int[] diceRolls = new int[10];
            int sum = 0;

            for (int i = 0; i < diceRolls.length; i++) {
                diceRolls[i] = (int) (Math.random() * 6) + 1; // 1~6 주사위 눈
                sum += diceRolls[i];
            }

            System.out.println("주사위 10회 기록: " + Arrays.toString(diceRolls));
            System.out.println("주사위 눈의 총합: " + sum);
        }
    }
}
