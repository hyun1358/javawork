package week02.day4;

/**
 * [학습 예제 3] Week 02 Day 4 — while / do-while 반복문 및 루프 제어
 * 
 * [학습 핵심 이론: 조건에 따라 유연하게 반복하는 while 루프]
 * 4. 반복문 제어 키워드 (break와 continue):
 *    - **break**: 자신이 속한 가장 가까운 반복문 전체를 즉시 중단하고 블록을 탈출합니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: break 문
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("--- Lab3: break 문 ---");
        Lab3.run();
        System.out.println("\n[해설] break는 반복문을 즉시 종료하고 빠져나옵니다.");
    }

    static class Lab3 {
        static void run() {
            int i = 1;
            while (i <= 10) {
                if (i == 5) {
                    System.out.println("5가 되어 중단합니다.");
                    break;
                }
                System.out.print(i + " ");
                i++;
            }
            System.out.println();
        }
    }
}
