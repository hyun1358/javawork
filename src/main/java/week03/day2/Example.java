package week03.day2;

import java.util.Arrays;

/**
 * [학습 예제] Week 03 Day 2 — 배열 활용 + 정렬
 * Lab1~Lab5를 순서대로 실행하며 배열의 강력한 기능을 익히세요.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 03 Day 2 학습 예제 ===\n");

        System.out.println("--- Lab1: Arrays.sort() 오름차순 정렬 ---");
        Lab1.run();
        System.out.println("\n[해설] Arrays.sort()는 가장 빠르고 편리하게 배열을 오름차순으로 정렬합니다.\n");

        System.out.println("--- Lab2: 버블 정렬 직접 구현 ---");
        Lab2.run();
        System.out.println("\n[해설] 버블 정렬은 인접한 두 값을 비교하며 자리를 바꾸는 가장 기초적인 정렬 알고리즘입니다.\n");

        System.out.println("--- Lab3: Arrays.toString() ---");
        Lab3.run();
        System.out.println("\n[해설] 배열의 내용을 [값1, 값2, ...] 형태로 문자열로 만들어줍니다. 출력 시 아주 편리합니다.\n");

        System.out.println("--- Lab4: 배열 복사 (Arrays.copyOf) ---");
        Lab4.run();
        System.out.println("\n[해설] 새 배열을 만들고 기존 값을 복사합니다. 길이를 조절할 수도 있습니다.\n");

        System.out.println("--- Lab5: for-each 문 (향상된 for문) ---");
        Lab5.run();
        System.out.println("\n[해설] 인덱스 없이 배열의 모든 값을 순차적으로 꺼낼 때 사용합니다. 코드가 아주 간결해집니다.\n");
    }

    static class Lab1 {
        static void run() {
            int[] arr = {5, 2, 9, 1, 3};
            Arrays.sort(arr);
            System.out.println("정렬 결과: " + Arrays.toString(arr));
        }
    }

    static class Lab2 {
        static void run() {
            int[] arr = {5, 2, 9, 1, 3};
            // 버블 정렬
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
            System.out.println("버블 정렬 결과: " + Arrays.toString(arr));
        }
    }

    static class Lab3 {
        static void run() {
            String[] fruits = {"사과", "바나나", "포도"};
            System.out.println(Arrays.toString(fruits));
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
            for (double w : weights) {
                System.out.print(w + "kg ");
            }
            System.out.println();
        }
    }
}
