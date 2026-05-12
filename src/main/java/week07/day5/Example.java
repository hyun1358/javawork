package week07.day5;

import java.util.Arrays;

/**
 * [학습 예제] Week 07 Day 5 — String 분리와 형식화
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: split 메서드 ===");
        String csv = "apple,banana,orange";
        String[] fruits = csv.split(",");
        System.out.println(Arrays.toString(fruits));

        System.out.println("\n=== Lab2: String.format ===");
        String formatted = String.format("총 금액: %,d원", 1000000);
        System.out.println(formatted);
    }
}
