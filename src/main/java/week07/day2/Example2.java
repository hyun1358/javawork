package week07.day2;

/**
 * [학습 예제 2] Week 07 Day 2 — Resource 해제와 try-with-resources
 * 
 * [학습 핵심 이론: 자원(Resource) 해제와 현대적 try-with-resources]
 * 1. finally 블록의 사명:
 *    - 심지어 `try` 내부에서 `return`을 만나 메서드가 즉시 종료되려 하더라도 **반드시 최종 실행**되므로 자원 해제 코드를 두기에 가장 안전한 구역입니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: try 블록 내 return문을 만나도 finally가 호출되는지 검증 (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab2: try 블록 내 return문을 만나도 finally가 호출되는지 검증 (Problem 2 연계) ---");
        int returnedValue = Lab2.runAndCheck();
        System.out.println("메서드가 최종 반환한 값: " + returnedValue);
    }

    static class Lab2 {
        static int runAndCheck() {
            // Problem 2: return과 finally 동작 순서
            try {
                System.out.println("[try] 작업을 완료하고 100을 return 하려고 합니다.");
                return 100; // 메서드 탈출 시도
            } catch (Exception e) {
                return -1;
            } finally {
                // return 되기 바로 직전에 반드시 실행됨을 보장!
                System.out.println("-> [finally] 메서드는 반환되지만 나는 약속대로 실행됩니다!");
            }
        }
    }
}
