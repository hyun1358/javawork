package week04.day2;

import java.util.Arrays;

/**
 * [학습 예제 3] Week 04 Day 2 — 메서드 매개변수 심화
 * 
 * [학습 핵심 이론: Call by Value 매커니즘 및 다형적 호출]
 * 4. 배열 반환 알고리즘:
 *    - 조건에 부합하는 요소를 판별한 후, 동적으로 새 배열을 할당하여 채워 넣고 그 참조 주소를 호출 측에 반환합니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: N까지의 소수(Prime) 배열 생성 및 반환 (Problem 4 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        // Problem 4: 1~N 범위의 소수(Prime) 배열 반환받기
        int limit = 20;
        int[] primes = getPrimes(limit);
        System.out.println("1부터 " + limit + "까지의 소수 목록: " + Arrays.toString(primes));
    }

    static int[] getPrimes(int n) {
        // 1. 먼저 소수가 총 몇 개인지 임시 카운트
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }

        // 2. 소수 개수만큼의 크기로 알맞은 정적 배열 할당
        int[] result = new int[count];
        int index = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                result[index++] = i;
            }
        }
        return result; // 생성된 소수 배열의 참조 주소 반환
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
