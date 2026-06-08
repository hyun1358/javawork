package week02.day2;

/**
 * [학습 예제 2] Week 02 Day 2 — switch 조건문 활용
 * 
 * [학습 핵심 이론: switch 분기 처리 패턴]
 * 2. default 처리:
 *    - default는 어떤 case에도 해당하지 않을 때 실행됩니다. (if의 else 역할)
 * 
 * [문제별 학습 목표]
 * - Lab2: default 처리
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("--- Lab2: default 처리 ---");
        Lab2.run();
        System.out.println("\n[해설] default는 어떤 case에도 해당하지 않을 때 실행됩니다. (if의 else 역할)");
    }

    static class Lab2 {
        static void run() {
            char grade = 'F';
            switch (grade) {
                case 'A':
                    System.out.println("우수");
                    break;
                case 'B':
                    System.out.println("보통");
                    break;
                default:
                    System.out.println("노력 필요");
            }
        }
    }
}
