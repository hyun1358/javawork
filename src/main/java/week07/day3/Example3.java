package week07.day3;

/**
 * [학습 예제 3] Week 07 Day 3 — 예외 발생과 전파
 * 
 * [학습 핵심 이론: 예외의 발생, 전파, 그리고 연결]
 * 3. Checked Exception vs Unchecked Exception:
 *    - Checked Exception: `RuntimeException`을 상속받지 않은 예외입니다. 컴파일러가 예외 처리(`try-catch` 또는 `throws`) 여부를 강제 검사하며, 위배 시 컴파일 에러가 납니다. (예: `IOException`)
 *    - Unchecked Exception: `RuntimeException` 계열 예외입니다. 컴파일러가 검사하지 않고 런타임에 결정되므로 유연하나 안전한 코딩이 요구됩니다. (예: `IllegalArgumentException`, `NullPointerException`)
 * 
 * [문제별 학습 목표]
 * - Lab3: Checked와 Unchecked 예외의 컴파일 특성 비교 (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab3: Checked와 Unchecked 예외의 컴파일 특성 비교 (Problem 3 연계) ---");
        Lab3.run();
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
}
