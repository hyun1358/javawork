package week07.day3;

import java.io.IOException;

/**
 * [학습 예제 2] Week 07 Day 3 — 예외 발생과 전파
 * 
 * [학습 핵심 이론: 예외의 발생, 전파, 그리고 연결]
 * 2. 예외의 선언 및 전파 (`throws` 키워드):
 *    - 메서드 내부에서 발생할 수 있는 Checked Exception을 자신이 처리하지 않고 자신을 호출한 위쪽 메서드(Caller)에게 처리를 미룰(throws) 때 사용합니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: Checked Exception (IOException) 선언과 복구 (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab2: Checked Exception (IOException) 선언과 복구 (Problem 2 연계) ---");
        Lab2.run();
    }

    static class Lab2 {
        static void run() {
            // Problem 2: IOException을 throws 하는 메서드 호출 처리
            try {
                throwCheckedException();
            } catch (IOException e) {
                System.out.println("[main] Checked 예외 IOException 포착 복구 완료: " + e.getMessage());
            }
        }

        // IOException은 Checked Exception이므로 반드시 throws 구문이 있어야 컴파일됩니다.
        static void throwCheckedException() throws IOException {
            throw new IOException("디바이스 통신 장애 발생");
        }
    }
}
