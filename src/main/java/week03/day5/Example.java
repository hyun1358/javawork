package week03.day5;

import java.util.Arrays;

/**
 * [학습 예제] Week 03 Day 5 — Math API와 난수 생성 (로또 난수, 주사위 통계, 좌표 거리, 랜덤 단어, 절대값 평균)
 * 
 * [학습 핵심 이론: Math 클래스와 난수(Random) 활용]
 * 1. Math.random():
 *    - `0.0` 이상 `1.0` 미만의 `double` 난수를 반환합니다 (`0.0 <= random < 1.0`).
 *    - 특정 범위 정수 난수 만드는 공식: `(int) (Math.random() * 범위내_정수_개수) + 시작값`
 *      - 예 (1~45 로또): `(int) (Math.random() * 45) + 1`
 *      - 예 (1~6 주사위): `(int) (Math.random() * 6) + 1`
 * 
 * 2. Math.pow(base, exponent) & Math.sqrt(value):
 *    - `Math.pow(a, b)`: a의 b제곱을 계산하여 `double`로 반환합니다.
 *    - `Math.sqrt(a)`: a의 제곱근(루트)을 계산하여 `double`로 반환합니다.
 *    - 기하학적 계산(예: 피타고라스 정리를 이용한 두 점 사이의 거리)에 널리 활용됩니다.
 * 
 * 3. Math.abs(value):
 *    - 인자로 전달된 정수 또는 실수의 절대값(양수화)을 계산해 반환합니다.
 * 
 * 4. 배열 기반 랜덤 선택:
 *    - 난수로 유효한 인덱스 범위 `(0 <= index < array.length)`를 추출하여 배열의 요소를 임의로 획득합니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 03 Day 5 학습 예제 ===\n");

        System.out.println("--- Lab1: 로또 번호 생성 (중복 허용 배열) (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: 주사위 10회 통계 및 합계 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: 피타고라스 정리를 이용한 좌표 간 거리 측정 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: 문자열 배열에서 무작위 단어 선택 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: 배열 요소들의 절대값 합산 및 평균 계산 (Problem 5 연계) ---");
        Lab5.run();

        System.out.println("\n--- Lab6: 기타 Math 올림/버림 유틸리티 메서드 ---");
        Lab6.run();
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

    static class Lab3 {
        static void run() {
            // Problem 3: 두 점 (0,0)과 (3,4) 사이의 직선 거리 구하기
            int x1 = 0, y1 = 0;
            int x2 = 3, y2 = 4;

            // 공식: sqrt((x2-x1)^2 + (y2-y1)^2)
            double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            System.out.printf("점 (%d,%d)와 (%d,%d) 사이의 거리: %.2f\n", x1, y1, x2, y2, distance);
        }
    }

    static class Lab4 {
        static void run() {
            // Problem 4: 무작위 단어 선택
            String[] words = {"Apple", "Book", "Car", "Java", "Python"};
            
            // 0 ~ (words.length - 1) 사이의 난수 인덱스
            int randIndex = (int) (Math.random() * words.length);
            String selected = words[randIndex];

            System.out.println("무작위로 선정된 오늘의 단어: " + selected);
        }
    }

    static class Lab5 {
        static void run() {
            // Problem 5: 배열 각 요소의 절대값의 합과 평균 계산
            int[] nums = {-10, 20, -30, 40};
            int sum = 0;

            for (int i = 0; i < nums.length; i++) {
                // Math.abs를 통해 양수화하여 합산
                sum += Math.abs(nums[i]);
            }
            double avg = (double) sum / nums.length;

            System.out.println("배열 절대값들의 합계: " + sum);
            System.out.println("배열 절대값들의 평균: " + avg);
        }
    }

    static class Lab6 {
        static void run() {
            // 버림, 올림, 반올림 API
            System.out.println("버림(Math.floor 3.9): " + Math.floor(3.9));
            System.out.println("올림(Math.ceil 3.1): " + Math.ceil(3.1));
            System.out.println("반올림(Math.round 3.5): " + Math.round(3.5));
        }
    }
}
