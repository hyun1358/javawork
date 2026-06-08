package week02.day2;

/**
 * [학습 예제 5] Week 02 Day 2 — switch 조건문 활용
 * 
 * [학습 핵심 이론: switch 분기 처리 패턴]
 * 5. JDK 12+ Switch Expression:
 *    - 화살표 연산자(`->`)를 활용하여 가독성을 극대화하고, 별도의 break 없이도 실행이 종료되는 모던 스위치 구문을 학습합니다.
 * 
 * [문제별 학습 목표]
 * - Lab5: Java 14+ switch 표현식
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("--- Lab5: Java 14+ switch 표현식 ---");
        Lab5.run();
        System.out.println("\n[해설] '->'를 사용하는 새로운 문법은 break가 필요 없고, 값을 바로 반환할 수 있어 편리합니다.");
    }

    static class Lab5 {
        static void run() {
            int day = 3; // 수요일
            String dayName = switch (day) {
                case 1 -> "월요일";
                case 2 -> "화요일";
                case 3 -> "수요일";
                case 4 -> "목요일";
                case 5 -> "금요일";
                default -> "주말";
            };
            System.out.println("오늘은 " + dayName);
        }
    }
}
