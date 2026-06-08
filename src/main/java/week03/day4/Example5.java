package week03.day4;

/**
 * [학습 예제 5] Week 03 Day 4 — 객체 참조와 병렬 배열
 * 
 * [문제별 학습 목표]
 * - Lab5: 문자열 배열 역순 출력 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab5: 문자열 배열 역순 출력 (Problem 5 연계) ---");
        Lab5.run();
    }

    static class Lab5 {
        static void run() {
            // Problem 5: String 배열 역순 출력
            String[] alphabet = {"A", "B", "C", "D"};
            System.out.print("역순 출력 결과: ");
            for (int i = alphabet.length - 1; i >= 0; i--) {
                System.out.print(alphabet[i] + " ");
            }
            System.out.println();
        }
    }
}
