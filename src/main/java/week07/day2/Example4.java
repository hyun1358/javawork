package week07.day2;

/**
 * [학습 예제 4] Week 07 Day 2 — Resource 해제와 try-with-resources
 * 
 * [문제별 학습 목표]
 * - Lab4: 예외 발생/미발생 두 가지 시나리오에서의 finally 실행 확인 (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab4: 예외 발생/미발생 두 가지 시나리오에서의 finally 실행 확인 (Problem 4 연계) ---");
        Lab4.run(true);  // 예외 유발
        Lab4.run(false); // 정상 작동
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
}
