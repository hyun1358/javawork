package week07.day2;

import java.util.Scanner;

/**
 * [학습 예제] Week 07 Day 2 — Resource 해제와 try-with-resources (finally 스캐너 종료, return문과 finally, try-with-resources 리팩토링, 예외 여부별 finally 실행, 중첩 try-catch)
 * 
 * [학습 핵심 이론: 자원(Resource) 해제와 현대적 try-with-resources]
 * 1. finally 블록의 사명:
 *    - 외부 리소스(Scanner, DB Connection, File I/O 등)는 가비지 컬렉터(GC)가 수거하지 못하므로 직접 해제해 주어야 합니다.
 *    - `finally` 블록은 예외 발생 여부와 전혀 무관하게, 심지어 `try` 내부에서 `return`을 만나 메서드가 즉시 종료되려 하더라도 **반드시 최종 실행**되므로 자원 해제 코드를 두기에 가장 안전한 구역입니다. (Problem 1, 2, 4 연계)
 * 
 * 2. try-with-resources (Java 7+):
 *    - try 소괄호 `try (Resource res = new Resource())` 안에 `AutoCloseable` 인터페이스를 구현한 자원을 선언하면, 블록 종료 시 자동으로 `.close()`를 호출해 줍니다.
 *    - 기존의 복잡하고 지저분한 finally 수동 close 코드(null 체크 + 중첩 try)를 획기적으로 정돈해 줍니다. (Problem 3 연계)
 * 
 * 3. 중첩 try-catch (Nested try-catch):
 *    - 예외가 발생할 수 있는 여러 스텝이 존재할 때, 내부 연산 중 특정 가벼운 에러는 별도로 잡아내어 정상 흐름을 이어가고, 더 큰 에러는 외부 try가 통제하도록 중첩 구조를 가질 수 있습니다. (Problem 5 연계)
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 07 Day 2 학습 예제 ===\n");

        System.out.println("--- Lab1: finally 블록을 이용한 명시적인 Scanner 자원 해제 (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: try 블록 내 return문을 만나도 finally가 호출되는지 검증 (Problem 2 연계) ---");
        int returnedValue = Lab2.runAndCheck();
        System.out.println("메서드가 최종 반환한 값: " + returnedValue);

        System.out.println("\n--- Lab3: try-with-resources 문법을 이용한 자원 해제 리팩토링 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: 예외 발생/미발생 두 가지 시나리오에서의 finally 실행 확인 (Problem 4 연계) ---");
        Lab4.run(true);  // 예외 유발
        Lab4.run(false); // 정상 작동

        System.out.println("\n--- Lab5: 중첩 try-catch 블록을 이용한 예외의 단계적 분기 처리 (Problem 5 연계) ---");
        Lab5.run();
    }

    static class Lab1 {
        static void run() {
            // Problem 1: finally에서 Scanner 수동 닫기
            Scanner sc = null;
            try {
                sc = new Scanner("임시 입력 소스");
                System.out.println("Scanner 자원을 획득하고 데이터를 읽습니다: " + sc.next());
            } catch (Exception e) {
                System.out.println("에러 발생: " + e.getMessage());
            } finally {
                // null 체크 후 안전하게 close 호출
                if (sc != null) {
                    sc.close();
                    System.out.println("-> [finally] Scanner 자원이 성공적으로 회수되었습니다.");
                }
            }
        }
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

    static class Lab3 {
        static void run() {
            // Problem 3: try-with-resources 리팩토링
            // Scanner는 AutoCloseable을 구현하므로 try 소괄호 안에 넣으면 close() 수동작성이 필요 없습니다.
            try (Scanner sc = new Scanner("자동 해제 데이터")) {
                System.out.println("try-with-resources 구동 데이터: " + sc.next());
                System.out.println("-> [자동화] 블록이 닫히면 자동으로 close()가 백그라운드에서 호출됩니다.");
            } catch (Exception e) {
                System.out.println("에러: " + e.getMessage());
            }
        }
    }

    static class Lab4 {
        static void run(boolean shouldFail) {
            // Problem 4: 예외 유무 관계 없이 실행되는 finally
            System.out.println("\n[시나리오 - 예외 발생 설정: " + shouldFail + "]");
            try {
                if (shouldFail) {
                    int crash = 10 / 0; // 예외 발생
                    System.out.println("결과: " + crash);
                } else {
                    System.out.println("정상 실행 영역 통과 중...");
                }
            } catch (ArithmeticException e) {
                System.out.println("catch 블록: 예외가 성공적으로 포착되었습니다.");
            } finally {
                System.out.println("-> [finally] 어떤 상황이든 나는 무조건 실행됩니다.");
            }
        }
    }

    static class Lab5 {
        static void run() {
            // Problem 5: 중첩 try-catch
            try {
                System.out.println("[외부 try 시작]");
                
                try {
                    System.out.println("  [내부 try] 0 나누기 예외를 발생시킵니다.");
                    int innerVal = 1 / 0; // 에러 유발
                    System.out.println("내부 계산: " + innerVal);
                } catch (ArithmeticException e) {
                    System.out.println("  [내부 catch] 0 나누기 예외를 여기서 국소 해결: " + e.getMessage());
                }

                // 외부 try 범위 내의 다른 작업
                System.out.println("[외부 try 진행] 배열 초과 예외를 발생시킵니다.");
                int[] arr = new int[2];
                arr[3] = 999; // 에러 유발 -> 외부 catch로 이동

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("[외부 catch] 배열 범위 초과 예외 감지 및 처리 완료: " + e.getMessage());
            }
        }
    }
}
