package week07.day2;

/**
 * [학습 예제 5] Week 07 Day 2 — Resource 해제와 try-with-resources
 * 
 * [학습 핵심 이론: 자원(Resource) 해제와 현대적 try-with-resources]
 * 3. 중첩 try-catch (Nested try-catch):
 *    - 예외가 발생할 수 있는 여러 스텝이 존재할 때, 내부 연산 중 특정 가벼운 에러는 별도로 잡아내어 정상 흐름을 이어가고, 더 큰 에러는 외부 try가 통제하도록 중첩 구조를 가질 수 있습니다.
 * 
 * [문제별 학습 목표]
 * - Lab5: 중첩 try-catch 블록을 이용한 예외의 단계적 분기 처리 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab5: 중첩 try-catch 블록을 이용한 예외의 단계적 분기 처리 (Problem 5 연계) ---");
        Lab5.run();
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
