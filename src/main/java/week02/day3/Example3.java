package week02.day3;

/**
 * [학습 예제 3] Week 02 Day 3 — for 반복문 기초
 * 
 * [학습 핵심 이론: 반복 횟수가 명확할 때 쓰는 for 루프]
 * 2. 중첩 for문 (Nested Loop):
 *    - 외부 루프가 한 번 돌 때마다 내부 루프가 지정된 횟수만큼 완전히 순회합니다.
 *    - 대표적인 예로 2차원 좌표 탐색이나 구구단 출력 등이 있으며, 시간 복잡도가 O(N^2)으로 급증하므로 과도한 중첩은 지양해야 합니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: 중첩 for 문 (구구단)
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("--- Lab3: 중첩 for 문 (구구단) ---");
        Lab3.run();
        System.out.println("\n[해설] 바깥쪽 for 문이 한 번 돌 때, 안쪽 for 문은 전체를 다 돕니다.");
    }

    static class Lab3 {
        static void run() {
            // 2단부터 3단까지만 예시
            for (int dan = 2; dan <= 3; dan++) {
                System.out.println("[" + dan + "단]");
                for (int i = 1; i <= 9; i++) {
                    System.out.println(dan + " * " + i + " = " + (dan * i));
                }
                System.out.println();
            }
        }
    }
}
