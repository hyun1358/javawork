package week02.day3;

/**
 * [학습 예제 4] Week 02 Day 3 — for 반복문 기초
 * 
 * [문제별 학습 목표]
 * - Lab4: 역순 반복
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("--- Lab4: 역순 반복 ---");
        Lab4.run();
        System.out.println("\n[해설] i-- 를 사용하여 큰 수에서 작은 수로 내려올 수 있습니다.");
    }

    static class Lab4 {
        static void run() {
            System.out.print("카운트다운: ");
            for (int i = 5; i >= 1; i--) {
                System.out.print(i + " ");
            }
            System.out.println("발사!");
        }
    }
}
