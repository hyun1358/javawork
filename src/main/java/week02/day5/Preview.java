package week02.day5;

/**
 * [예습 파일] Week 02 Day 5 — 반복문 심화 (이중 루프와 레이블)
 */
public class Preview {
    public static void main(String[] args) {
        // 1. 구구단 전체 출력 (이중 for문)
        System.out.println("--- 구구단 전체 ---");
        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%d * %d = %d\t", i, j, i * j);
            }
            System.out.println();
        }

        // 2. 무한 루프와 탈출
        System.out.println("\n--- 무한 루프 탈출 ---");
        int count = 0;
        while (true) {
            count++;
            if (count > 5) break;
            System.out.println("카운트: " + count);
        }
    }
}
