package week07.day3;

import java.io.IOException;

/**
 * [학습 예제 4] Week 07 Day 3 — 예외 발생과 전파
 * 
 * [학습 핵심 이론: 예외의 발생, 전파, 그리고 연결]
 * 2. 예외의 선언 및 전파 (`throws` 키워드):
 *    - 여러 단계에 걸쳐 예외가 상위 호출자로 전파(Propagation)되는 과정을 보여줍니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: 3단계 수직 예외 전파 (C -> B -> A -> main) (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab4: 3단계 수직 예외 전파 (C -> B -> A -> main) (Problem 4 연계) ---");
        Lab4.run();
    }

    static class Lab4 {
        static void run() {
            // Problem 4: A가 B를, B가 C를 호출하고 C가 던진 예외를 A가 최종 처리하는 3단계 전파
            System.out.println("메서드 A() 호출 시도...");
            A();
        }

        static void A() {
            try {
                B();
            } catch (IOException e) {
                System.out.println("[A 메서드] 최종 3단계 전파된 오류 포착 완료: " + e.getMessage());
            }
        }

        static void B() throws IOException {
            C(); // 예외를 전달받아 위로 전달
        }

        static void C() throws IOException {
            // C에서 Checked 예외 강제 발생
            throw new IOException("C 메서드의 물리 센서 오류");
        }
    }
}
