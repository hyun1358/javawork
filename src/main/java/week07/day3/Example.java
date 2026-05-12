package week07.day3;

import java.io.IOException;

/**
 * [학습 예제] Week 07 Day 3 — 예외 전파 체인
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: Checked Exception 전파 ===");
        try {
            methodA();
        } catch (IOException e) {
            System.out.println("main에서 잡음: " + e.getMessage());
        }
    }

    public static void methodA() throws IOException {
        methodB(); // 예외를 전달받아 다시 위로 던짐
    }

    public static void methodB() throws IOException {
        throw new IOException("파일 입출력 에러 발생!"); // 강제 발생
    }
}
