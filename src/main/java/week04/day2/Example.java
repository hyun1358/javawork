package week04.day2;

import java.util.Arrays;

/**
 * [학습 예제] Week 04 Day 2 — 메서드 매개변수 심화
 * 기본형 vs 참조형의 차이와 가변 인자를 다룹니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 04 Day 2 학습 예제 ===\n");

        System.out.println("--- Lab1: 기본형 매개변수 (Call by Value) ---");
        Lab1.run();
        System.out.println("\n[해설] 기본형(int, double 등)은 '값'이 복사되므로 메서드에서 바꿔도 원본은 안 바뀝니다.\n");

        System.out.println("--- Lab2: 참조형 매개변수 (Call by Reference) ---");
        Lab2.run();
        System.out.println("\n[해설] 참조형(배열, 객체)은 '주소'가 전달되므로 메서드에서 바꾸면 원본도 바뀝니다.\n");

        System.out.println("--- Lab3: 가변 인자 (Variable Arguments) ---");
        Lab3.run();
        System.out.println("\n[해설] 매개변수 개수가 유동적일 때 '...'을 사용합니다.\n");

        System.out.println("--- Lab4: 메서드에서 배열 반환 ---");
        Lab4.run();
        System.out.println("\n[해설] 메서드의 반환 타입으로 배열을 사용할 수도 있습니다.\n");

        System.out.println("--- Lab5: 배열 유틸리티 메서드 호출 ---");
        Lab5.run();
        System.out.println("\n[해설] 배열을 다루는 반복적인 기능은 메서드로 분리하는 것이 좋습니다.\n");
    }

    static class Lab1 {
        static void run() {
            int n = 100;
            update(n);
            System.out.println("main의 n: " + n); // 100 출력
        }

        static void update(int n) {
            n = 200;
        }
    }

    static class Lab2 {
        static void run() {
            int[] nums = {100};
            updateArray(nums);
            System.out.println("main의 nums[0]: " + nums[0]); // 200 출력
        }

        static void updateArray(int[] arr) {
            arr[0] = 200;
        }
    }

    static class Lab3 {
        static void run() {
            printSum(1, 2, 3);
            printSum(10, 20, 30, 40, 50);
        }

        static void printSum(int... values) {
            int total = 0;
            for (int v : values) total += v;
            System.out.println("총합: " + total);
        }
    }

    static class Lab4 {
        static void run() {
            int[] result = makeArray(3);
            System.out.println("생성된 배열: " + Arrays.toString(result));
        }

        static int[] makeArray(int size) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) arr[i] = i + 1;
            return arr;
        }
    }

    static class Lab5 {
        static void run() {
            int[] nums = {5, 2, 8, 1};
            int max = findMax(nums);
            System.out.println("최댓값: " + max);
        }

        static int findMax(int[] arr) {
            int m = arr[0];
            for (int a : arr) if (a > m) m = a;
            return m;
        }
    }
}
