package week03.day2;

import java.util.Arrays;

/**
 * [학습 예제] Week 03 Day 2 — 배열 정렬 및 응용 (배열 병합, 중복 찾기, 배열 회전)
 * 
 * [학습 핵심 이론: 배열 조작 및 알고리즘 기초]
 * 1. Arrays.sort():
 *    - Java 내부에서 구현된 듀얼피벗 퀵정렬(Dual-Pivot Quicksort) 등을 사용하여 배열을 빠르고 효율적으로 오름차순 정렬합니다.
 * 
 * 2. 버블 정렬(Bubble Sort):
 *    - 가장 인접한 두 요소를 비교하며 위치를 교환(Swap)해 나가는 단순 정렬 알고리즘입니다.
 *    - 시간 복잡도는 O(N^2)이며, 직관적인 반복 루프 처리를 연습하기에 훌륭합니다.
 * 
 * 3. 배열 병합(Merge):
 *    - 두 배열의 데이터를 하나의 큰 배열로 합치는 기법입니다.
 *    - 새 배열을 `arr1.length + arr2.length` 크기로 만들고, 루프 또는 `System.arraycopy()`를 이용하여 데이터를 차례로 복사합니다.
 * 
 * 4. 중첩 루프를 이용한 중복 검색:
 *    - 이중 `for`문 구조로, 바깥 인덱스 `i`와 안쪽 인덱스 `j = i + 1`을 순차 비교해 가며 중복 요소를 검출해 냅니다.
 * 
 * 5. 배열 요소 회전(Rotation):
 *    - 배열의 원소들을 좌측이나 우측으로 미는 기법입니다. 임시 변수(`temp`)를 이용해 덮어씌워져 유실되는 값을 별도로 백업하는 절차가 필요합니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 03 Day 2 학습 예제 ===\n");

        System.out.println("--- Lab1: Arrays.sort() 오름차순 정렬 (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: 버블 정렬 직접 구현 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: Arrays.toString() 활용 ---");
        Lab3.run();

        System.out.println("\n--- Lab4: 배열 복사 (Arrays.copyOf) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: 향상된 for-each 문 활용 ---");
        Lab5.run();

        System.out.println("\n--- Lab6: 두 배열 하나로 합치기 (Problem 3 연계) ---");
        Lab6.run();

        System.out.println("\n--- Lab7: 중첩 루프로 중복 값 찾기 (Problem 4 연계) ---");
        Lab7.run();

        System.out.println("\n--- Lab8: 배열 왼쪽으로 회전(쉬프트) (Problem 5 연계) ---");
        Lab8.run();
    }

    static class Lab1 {
        static void run() {
            int[] arr = {34, 12, 89, 5, 21};
            Arrays.sort(arr);
            System.out.println("Arrays.sort 정렬 결과: " + Arrays.toString(arr));
        }
    }

    static class Lab2 {
        static void run() {
            int[] arr = {15, 7, 22, 1, 9};
            // 버블 정렬 구현
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // Swap
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
            System.out.println("직접 구현한 버블 정렬 결과: " + Arrays.toString(arr));
        }
    }

    static class Lab3 {
        static void run() {
            String[] fruits = {"사과", "바나나", "포도"};
            System.out.println("Arrays.toString 출력: " + Arrays.toString(fruits));
        }
    }

    static class Lab4 {
        static void run() {
            int[] origin = {1, 2, 3};
            int[] copy = Arrays.copyOf(origin, origin.length);
            System.out.println("원본: " + Arrays.toString(origin));
            System.out.println("복사본: " + Arrays.toString(copy));
        }
    }

    static class Lab5 {
        static void run() {
            double[] weights = {65.5, 70.2, 58.9};
            System.out.print("weights 출력: ");
            for (double w : weights) {
                System.out.print(w + "kg ");
            }
            System.out.println();
        }
    }

    static class Lab6 {
        static void run() {
            // Problem 3: 두 배열 합치기
            int[] arr1 = {1, 2, 3};
            int[] arr2 = {4, 5, 6};
            int[] combined = new int[arr1.length + arr2.length];

            // 1. 첫 번째 배열 복사
            for (int i = 0; i < arr1.length; i++) {
                combined[i] = arr1[i];
            }
            // 2. 두 번째 배열 복사 (오프셋 적용)
            for (int i = 0; i < arr2.length; i++) {
                combined[arr1.length + i] = arr2[i];
            }

            System.out.println("병합된 배열: " + Arrays.toString(combined));
        }
    }

    static class Lab7 {
        static void run() {
            // Problem 4: 중복된 요소 찾기
            int[] nums = {10, 20, 30, 20, 40, 10};
            System.out.print("검출된 중복 숫자: ");
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        System.out.print(nums[i] + " ");
                    }
                }
            }
            System.out.println();
        }
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
