package week07.day3;

import java.io.IOException;

/**
 * [학습 예제] Week 07 Day 3 — 예외 발생과 전파 (IllegalArgumentException 던지기, Checked Exception 선언, Checked vs Unchecked 차이, 3단계 예외 전파, 예외 감싸기 Wrapping)
 * 
 * [학습 핵심 이론: 예외의 발생, 전파, 그리고 연결]
 * 1. 예외의 능동적 발생 (`throw` 키워드):
 *    - 프로그램 조건에 맞지 않는 상황(예: 음수 입력)을 감지하면 `throw new ExceptionClass("메시지")` 문장으로 강제 에러를 발생시켜 비정상 처리를 통제할 수 있습니다. (Problem 1 연계)
 * 
 * 2. 예외의 선언 및 전파 (`throws` 키워드):
 *    - 메서드 내부에서 발생할 수 있는 Checked Exception을 자신이 처리하지 않고 자신을 호출한 위쪽 메서드(Caller)에게 처리를 미룰(throws) 때 사용합니다. (Problem 2, 4 연계)
 * 
 * 3. Checked Exception vs Unchecked Exception:
 *    - Checked Exception: `RuntimeException`을 상속받지 않은 예외입니다. 컴파일러가 예외 처리(`try-catch` 또는 `throws`) 여부를 강제 검사하며, 위배 시 컴파일 에러가 납니다. (예: `IOException`)
 *    - Unchecked Exception: `RuntimeException` 계열 예외입니다. 컴파일러가 검사하지 않고 런타임에 결정되므로 유연하나 안전한 코딩이 요구됩니다. (예: `IllegalArgumentException`, `NullPointerException`) (Problem 3 연계)
 * 
 * 4. 예외 감싸기 (Exception Wrapping):
 *    - 예외가 발생했을 때 이를 캐치하여 에러 원인(`cause`)으로 삼아 새로운 Unchecked 예외(`RuntimeException`)에 담아 상위로 다시 던지는 핵심 실무 기법입니다. API의 불필요한 checked throws 선언을 줄여줍니다. (Problem 5 연계)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 07 Day 3 학습 예제 ===\n");

        System.out.println("--- Lab1: IllegalArgumentException 강제 발생 및 캐치 (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: Checked Exception (IOException) 선언과 복구 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: Checked와 Unchecked 예외의 컴파일 특성 비교 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: 3단계 수직 예외 전파 (C -> B -> A -> main) (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: 원인 예외를 보관하는 예외 감싸기(Wrapping) 기법 (Problem 5 연계) ---");
        Lab5.run();
    }

    static class Lab1 {
        static void run() {
            // Problem 1: 음수 입력 시 예외를 던지는 시뮬레이션
            int input = -10;
            try {
                System.out.println("입력값 검증 시도: " + input);
                if (input < 0) {
                    throw new IllegalArgumentException("음수 입력 불가 (전달 값: " + input + ")");
                }
                System.out.println("정상값 통과");
            } catch (IllegalArgumentException e) {
                System.out.println("예외 감지 성공! 사유: " + e.getMessage());
            }
        }
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

    static class Lab3 {
        static void run() {
            System.out.println("[Checked vs Unchecked 특징 비교]");
            System.out.println("1. Checked Exception (예: IOException):");
            System.out.println("   - throws 선언이나 try-catch가 강제됩니다. 생략 시 즉시 컴파일 에러!");
            System.out.println("2. Unchecked Exception (예: IllegalArgumentException):");
            System.out.println("   - 예외 처리가 강제되지 않아 코드가 깔끔하나 런타임 종료를 막기 위해 처리가 필요할 수 있습니다.");
        }
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

    static class Lab5 {
        static void run() {
            // Problem 5: NullPointerException을 감싸서 RuntimeException으로 던지기
            try {
                System.out.println("NPE 유발 및 감싸기 시도...");
                simulateWrapping();
            } catch (RuntimeException e) {
                System.out.println("[최상위 catch] 감싸진 예외 감지: " + e.getMessage());
                System.out.println("[진짜 원인 추적] 원인(Cause) 예외 객체: " + e.getCause());
            }
        }

        static void simulateWrapping() {
            try {
                String s = null;
                s.length(); // NullPointerException 유발
            } catch (NullPointerException e) {
                // NPE(원인 예외)를 새로운 RuntimeException 생성자의 인자로 던져 연결 체인을 맺음
                throw new RuntimeException("문자열 데이터 조작 중 오류 발생!", e);
            }
        }
    }
}
