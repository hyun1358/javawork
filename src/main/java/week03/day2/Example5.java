package week03.day2;

/**
 * [학습 예제 5] Week 03 Day 2 — 배열 정렬 및 응용
 * 
 * [학습 핵심 이론: 배열 조작 및 알고리즘 기초]
 * 5. 배열 요소 회전(Rotation):
 *    - 배열의 원소들을 좌측이나 우측으로 미는 기법입니다. 임시 변수(`temp`)를 이용해 덮어씌워져 유실되는 값을 별도로 백업하는 절차가 필요합니다.
 * 
 * [문제별 학습 목표]
 * - Lab8: 배열 왼쪽으로 회전(쉬프트) (Problem 5 연계)
 */
import java.util.Arrays;

public class Example5 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab8: 배열 왼쪽으로 회전(쉬프트) (Problem 5 연계) ---");
        Lab8.run();
    }

    static class Lab8 {
        static void run() {
            // Problem 5: 배열 원소를 왼쪽으로 한 칸 회전
            // {1, 2, 3, 4, 5} -> {2, 3, 4, 5, 1}
            int[] arr = {1, 2, 3, 4, 5};
            System.out.println("회전 전: " + Arrays.toString(arr));

            int temp = arr[0]; // 맨 앞 요소 임시 백업
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1]; // 뒤의 값을 앞으로 당김
            }
            arr[arr.length - 1] = temp; // 백업된 맨 앞 값을 맨 뒤로 삽입

            System.out.println("회전 후: " + Arrays.toString(arr));
        }
    }
}
