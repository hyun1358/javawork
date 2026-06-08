package week03.day5;

/**
 * [학습 예제 1] Week 03 Day 5 — Math API와 난수 생성
 * 
 * [학습 핵심 이론: Math 클래스와 난수(Random) 활용]
 * 1. Math.random():
 *    - `0.0` 이상 `1.0` 미만의 `double` 난수를 반환합니다 (`0.0 <= random < 1.0`).
 *    - 특정 범위 정수 난수 만드는 공식: `(int) (Math.random() * 범위내_정수_개수) + 시작값`
 *      - 예 (1~45 로또): `(int) (Math.random() * 45) + 1`
 * 
 * [문제별 학습 목표]
 * - Lab1: 로또 번호 생성 (중복 허용 배열) (Problem 1 연계)
 */
import java.util.Arrays;

public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: 로또 번호 생성 (중복 허용 배열) (Problem 1 연계) ---");
        Lab1.run();
    }

    static class Lab1 {
        static void run() {
            // Problem 1: 1~45 사이의 난수 6개를 뽑아 배열에 저장 후 출력 (중복 허용 버전)
            int[] lotto = new int[6];
            for (int i = 0; i < lotto.length; i++) {
                // 1부터 45까지
                lotto[i] = (int) (Math.random() * 45) + 1;
            }
            System.out.println("생성된 로또 번호: " + Arrays.toString(lotto));
        }
    }
}
