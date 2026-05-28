package week07.day1;

/**
 * [학습 예제] Week 07 Day 1 — 예외 처리(Exception Handling) 기초 (ArithmeticException, ArrayIndexOutOfBoundsException, NumberFormatException, NullPointerException, 다중 catch 블록)
 * 
 * [학습 핵심 이론: 자바 예외 처리 메커니즘]
 * 1. 예외(Exception)와 에러(Error):
 *    - 에러(Error)는 메모리 부족(OOM) 등 프로그램이 복구할 수 없는 치명적 상황이며, 예외(Exception)는 개발자가 `try-catch`로 포착하여 정상 흐름으로 복구할 수 있는 경미한 결함입니다.
 * 
 * 2. try-catch 구조:
 *    - `try { ... }`: 예외가 발생할 위험이 있는 감시 코드를 작성합니다.
 *    - `catch (ExceptionType e) { ... }`: try 내에서 해당 예외가 터지면 제어권이 넘어와 에러 복구/안내를 처리합니다.
 * 
 * 3. 다중 catch 블록과 예외 계층 구조:
 *    - 여러 종류의 예외를 각각 별도로 디테일하게 복구할 때 사용합니다.
 *    - 주의: 상속 계층상 **자식 예외 클래스**를 위쪽 catch에 먼저 적고, **부모 예외 클래스(Exception 등)**를 아래쪽에 배치해야 합니다. 부모 예외를 위에 두면 아래 자식 catch는 도달 불가하여 컴파일 에러가 납니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 07 Day 1 학습 예제 ===\n");

        System.out.println("--- Lab1: ArithmeticException (0 나누기 오류) 처리 (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: ArrayIndexOutOfBoundsException (배열 인덱스 초과) 처리 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: NumberFormatException (숫자 파싱 오류) 처리 (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: NullPointerException (참조값 없음 오류) 처리 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: 정교한 다중 catch 블록 분기 구조 구현 (Problem 5 연계) ---");
        Lab5.run();
    }

    static class Lab1 {
        static void run() {
            try {
                // Problem 1: 5를 0으로 나누어 고의로 ArithmeticException 유발
                int result = 5 / 0;
                System.out.println("나눗셈 결과: " + result);
            } catch (ArithmeticException e) {
                System.out.println("예외 처리 완료: 0으로 숫자를 나눌 수 없습니다! (" + e.getMessage() + ")");
            }
        }
    }

    static class Lab2 {
        static void run() {
            try {
                // Problem 2: 크기가 2인 배열에 3번째 값(인덱스 2) 대입 시도
                int[] arr = new int[2];
                arr[2] = 100;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("예외 처리 완료: 유효하지 않은 배열 인덱스 접근입니다! (" + e.getMessage() + ")");
            }
        }
    }

    static class Lab3 {
        static void run() {
            try {
                // Problem 3: 숫자로 파싱이 불가능한 문자열 "ABC" 파싱 시도
                String source = "ABC";
                int number = Integer.parseInt(source);
                System.out.println("변환된 숫자: " + number);
            } catch (NumberFormatException e) {
                System.out.println("예외 처리 완료: 숫자로 변환할 수 없는 문자열 포맷입니다! (" + e.getMessage() + ")");
            }
        }
    }

    static class Lab4 {
        static void run() {
            try {
                // Problem 4: null 객체의 인스턴스 메서드(length()) 호출 시도
                String str = null;
                System.out.println("문자열 길이: " + str.length());
            } catch (NullPointerException e) {
                System.out.println("예외 처리 완료: 가리키는 실제 메모리 객체가 없습니다! (NullPointerException)");
            }
        }
    }

    static class Lab5 {
        static void run() {
            // Problem 5: 다중 catch
            System.out.println("[다중 catch 시뮬레이션]");
            for (int i = 0; i < 2; i++) {
                try {
                    if (i == 0) {
                        // 1. 배열 초과 오류 먼저 유발
                        int[] temp = new int[3];
                        System.out.println(temp[5]);
                    } else {
                        // 2. 0 나누기 오류 유발
                        int calc = 10 / 0;
                        System.out.println("연산: " + calc);
                    }
                } 
                // 구체적인 하위 자식 예외 1
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("-> [catch 1] 배열 범위 초과 예외 감지! (" + e.toString() + ")");
                } 
                // 구체적인 하위 자식 예외 2
                catch (ArithmeticException e) {
                    System.out.println("-> [catch 2] 0 나누기 산술 계산 예외 감지! (" + e.toString() + ")");
                }
                // 최상위 예외 (기타 모든 미포착 예외 그물망)
                catch (Exception e) {
                    System.out.println("-> [catch 3] 기타 예외 감지! (" + e.toString() + ")");
                }
            }
        }
    }
}
