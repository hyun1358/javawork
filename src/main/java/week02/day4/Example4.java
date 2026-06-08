package week02.day4;

/**
 * [학습 예제 4] Week 02 Day 4 — while / do-while 반복문 및 루프 제어
 * 
 * [학습 핵심 이론: 조건에 따라 유연하게 반복하는 while 루프]
 * 4. 반복문 제어 키워드 (break와 continue):
 *    - **continue**: 반복문의 남은 하위 코드를 건너뛰고, 즉시 다음 반복 회차(for의 증감식 또는 while의 조건식)로 점프합니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: continue 문
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("--- Lab4: continue 문 ---");
        Lab4.run();
        System.out.println("\n[해설] continue는 아래 코드를 무시하고 다음 반복 회차로 즉시 넘어갑니다.");
    }

    static class Lab4 {
        static void run() {
            for (int i = 1; i <= 5; i++) {
                if (i == 3) {
                    System.out.println("(3은 건너뜁니다)");
                    continue;
                }
                System.out.println("숫자: " + i);
            }
        }
    }
}
