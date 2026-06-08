package week01.day3;

/**
 * [학습 예제 4] Week 01 Day 3 — 연산자 종합
 * 
 * [학습 핵심 이론: 자바의 연산자 체계]
 * 5. 복합 대입 연산자 (Assignment Operators):
 *    - +=, -=, *=, /=, %= 등
 *    - 대입 연산과 산술 연산을 한 묶음으로 줄여 쓰는 문법입니다 (예: n += 5 -> n = n + 5).
 * 
 * [문제별 학습 목표]
 * - Lab4: 복합 대입 연산자 (+=, -=, *=, /=, %=)
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("--- Lab4: 복합 대입 연산자 (+=, -=, *=, /=, %=) ---");
        Lab4.run();
        System.out.println("\n[해설] a += b는 a = a + b와 같은 의미입니다.");
    }

    static class Lab4 {
        static void run() {
            int n = 10;
            n += 5; // n = 15
            System.out.println("n += 5 결과: " + n);
            n *= 2; // n = 30
            System.out.println("n *= 2 결과: " + n);
        }
    }
}
