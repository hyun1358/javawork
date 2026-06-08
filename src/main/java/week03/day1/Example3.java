package week03.day1;

/**
 * [학습 예제 3] Week 03 Day 1 — 1차원 배열 기초
 * 
 * [학습 핵심 이론: 순차 데이터 구조 - 배열]
 * 3. 인덱스(Index) 바운드:
 *    - 인덱스는 0부터 (배열크기 - 1)까지 존재합니다. 이 범위를 벗어나면 `ArrayIndexOutOfBoundsException`이 발생합니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: 인덱스로 접근 및 .length
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab3: 인덱스로 접근 및 .length ---");
        Lab3.run();
    }

    static class Lab3 {
        static void run() {
            int[] data = new int[5];
            System.out.println("배열 크기: " + data.length);
            // 마지막 인덱스는 항상 length - 1 입니다.
            data[data.length - 1] = 100; 
            System.out.println("마지막 인덱스(4) 값: " + data[4]);
        }
    }
}
