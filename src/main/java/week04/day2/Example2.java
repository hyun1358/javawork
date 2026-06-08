package week04.day2;

/**
 * [학습 예제 2] Week 04 Day 2 — 메서드 매개변수 심화
 * 
 * [학습 핵심 이론: Call by Value 매커니즘 및 다형적 호출]
 * 3. 가변인자 (Varargs, `Type... name`):
 *    - 인자 개수를 동적으로 결정할 수 있게 해 주며, 메서드 내에서는 배열처럼 사용됩니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: 가변 인자(Varargs)를 활용한 합계 반환 (Problem 2, 3 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        // Problem 2, 3: 가변 인자를 받아 합계를 구한 뒤 반환하는 sumAll 구현
        int sum1 = sumAll(1, 2, 3);
        int sum2 = sumAll(10, 20, 30, 40, 50);

        System.out.println("sumAll(1, 2, 3) 결과: " + sum1);
        System.out.println("sumAll(10, 20, 30, 40, 50) 결과: " + sum2);
    }

    static int sumAll(int... numbers) {
        int total = 0;
        // numbers는 메서드 안에서 일반 배열과 완전히 동일하게 취급됩니다.
        for (int num : numbers) {
            total += num;
        }
        return total;
    }
}
