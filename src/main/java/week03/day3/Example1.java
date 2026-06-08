package week03.day3;

/**
 * [학습 예제 1] Week 03 Day 3 — 2차원 배열과 격자 데이터
 * 
 * [학습 핵심 이론: 2차원 배열과 격자 데이터 제어]
 * 1. 2차원 배열의 구조:
 *    - 2차원 배열은 사실 '배열의 배열'입니다. `matrix.length`는 행의 개수를, `matrix[i].length`는 i번째 행의 열 개수를 뜻합니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: 2차원 배열 선언, 초기화 및 출력 (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: 2차원 배열 선언, 초기화 및 출력 (Problem 1 연계) ---");
        Lab1.run();
    }

    static class Lab1 {
        static void run() {
            // Problem 1: 3x3 2차원 배열 선언 및 값 대입 후 출력
            int[][] arr = new int[3][3];
            int num = 1;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = num++;
                }
            }

            // 출력 확인
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }
}
