package week02.day2;

/**
 * [학습 예제 3] Week 02 Day 2 — switch 조건문 활용
 * 
 * [학습 핵심 이론: switch 분기 처리 패턴]
 * 3. break 생략(Fall-through 활용):
 *    - break문을 의도적으로 생략하여 여러 개의 case가 동일한 실행 코드를 공유하도록 처리할 수 있습니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: break 생략(Fall-through)
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("--- Lab3: break 생략(Fall-through) ---");
        Lab3.run();
        System.out.println("\n[해설] break를 생략하면 다음 case가 조건에 상관없이 계속 실행됩니다.");
    }

    static class Lab3 {
        static void run() {
            int month = 10;
            // 의도적으로 break를 안 쓴 경우
            switch (month) {
                case 9:
                case 10:
                case 11:
                    System.out.println("가을입니다.");
                    break;
            }
        }
    }
}
