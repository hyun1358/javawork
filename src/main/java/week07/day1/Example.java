package week07.day1;

/**
 * [학습 예제] Week 07 Day 1 — 다중 catch와 최상위 Exception
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: 배열 범위 초과 예외 ===");
        try {
            int[] arr = new int[3];
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열 인덱스 오류: " + e.getMessage());
        }

        System.out.println("\n=== Lab2: NullPointerException ===");
        try {
            String str = null;
            System.out.println(str.length());
        } catch (Exception e) {
            System.out.println("모든 예외를 잡는 최상위 Exception: " + e.toString());
        }
    }
}
