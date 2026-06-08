package week07.day3;

/**
 * [학습 예제 5] Week 07 Day 3 — 예외 발생과 전파
 * 
 * [학습 핵심 이론: 예외의 발생, 전파, 그리고 연결]
 * 4. 예외 감싸기 (Exception Wrapping):
 *    - 예외가 발생했을 때 이를 캐치하여 에러 원인(`cause`)으로 삼아 새로운 Unchecked 예외(`RuntimeException`)에 담아 상위로 다시 던지는 핵심 실무 기법입니다. API의 불필요한 checked throws 선언을 줄여줍니다.
 * 
 * [문제별 학습 목표]
 * - Lab5: 원인 예외를 보관하는 예외 감싸기(Wrapping) 기법 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab5: 원인 예외를 보관하는 예외 감싸기(Wrapping) 기법 (Problem 5 연계) ---");
        Lab5.run();
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
