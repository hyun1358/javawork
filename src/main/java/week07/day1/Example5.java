package week07.day1;

/**
 * [학습 예제 5] Week 07 Day 1 — 예외 처리(Exception Handling) 기초
 * 
 * [학습 핵심 이론: 자바 예외 처리 메커니즘]
 * 3. 다중 catch 블록과 예외 계층 구조:
 *    - 여러 종류의 예외를 각각 별도로 디테일하게 복구할 때 사용합니다.
 *    - 주의: 상속 계층상 **자식 예외 클래스**를 위쪽 catch에 먼저 적고, **부모 예외 클래스(Exception 등)**를 아래쪽에 배치해야 합니다. 부모 예외를 위에 두면 아래 자식 catch는 도달 불가하여 컴파일 에러가 납니다.
 * 
 * [문제별 학습 목표]
 * - Lab5: 정교한 다중 catch 블록 분기 구조 구현 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab5: 정교한 다중 catch 블록 분기 구조 구현 (Problem 5 연계) ---");
        Lab5.run();
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
