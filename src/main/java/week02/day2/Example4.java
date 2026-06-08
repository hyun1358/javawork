package week02.day2;

/**
 * [학습 예제 4] Week 02 Day 2 — switch 조건문 활용
 * 
 * [학습 핵심 이론: switch 분기 처리 패턴]
 * 4. 문자열(String) 비교 switch:
 *    - JDK 7 버전부터 대소문자 구분이 명확한 문자열 비교가 가능해졌습니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: 여러 case 묶기
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("--- Lab4: 여러 case 묶기 ---");
        Lab4.run();
        System.out.println("\n[해설] 여러 case에 대해 같은 처리를 할 때 break 없이 나열하여 묶을 수 있습니다.");
    }

    static class Lab4 {
        static void run() {
            String position = "과장";
            switch (position) {
                case "부장":
                case "차장":
                    System.out.println("관리자");
                    break;
                case "과장":
                case "대리":
                case "사원":
                    System.out.println("실무자");
                    break;
            }
        }
    }
}
