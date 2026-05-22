package week07.day3;

import java.io.IOException;

/**
 * [학습 예제] Week 07 Day 3 — 예외 전파 체인 및 예외 연결(Exception Chaining)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: Checked Exception 전파 ===");
        try {
            methodA();
        } catch (IOException e) {
            System.out.println("main에서 잡음: " + e.getMessage());
        }

        System.out.println("\n=== Lab2: 예외 연결 (Exception Chaining) ===");
        try {
            chainedMethod();
        } catch (RuntimeException e) {
            System.out.println("main에서 잡은 RuntimeException: " + e.getMessage());
            System.out.println("실제 원인 예외(Cause): " + e.getCause());
        }
    }

    public static void methodA() throws IOException {
        methodB(); // 예외를 전달받아 다시 위로 던짐
    }

    public static void methodB() throws IOException {
        throw new IOException("파일 입출력 에러 발생!"); // 강제 발생
    }

    public static void chainedMethod() {
        try {
            throw new IOException("DB 디스크 문제 발생");
        } catch (IOException e) {
            // Checked 예외인 IOException을 Unchecked 예외인 RuntimeException에 담아서 던집니다.
            throw new RuntimeException("비즈니스 로직 처리 중 치명적 에러 발생", e);
        }
    }
}
