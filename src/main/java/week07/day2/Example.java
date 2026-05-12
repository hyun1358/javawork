package week07.day2;

import java.util.Scanner;

/**
 * [학습 예제] Week 07 Day 2 — try-with-resources
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab: try-with-resources ===");
        // 자동으로 close()가 호출되는 형태입니다. (Java 7+)
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("이 블록이 끝나면 Scanner가 자동으로 닫힙니다.");
        } catch (Exception e) {
            System.out.println("예외 발생 시에도 닫힘 보장");
        }
    }
}
