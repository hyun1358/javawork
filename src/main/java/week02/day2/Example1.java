package week02.day2;

/**
 * [학습 예제 1] Week 02 Day 2 — switch 조건문 활용
 * 
 * [학습 핵심 이론: switch 분기 처리 패턴]
 * 1. 기본 switch-case-break:
 *    - switch 문은 변수의 값과 일치하는 case를 찾아 실행합니다. break가 필수입니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: 기본 switch-case-break
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: 기본 switch-case-break ---");
        Lab1.run();
        System.out.println("\n[해설] switch 문은 변수의 값과 일치하는 case를 찾아 실행합니다. break가 필수입니다.");
    }

    static class Lab1 {
        static void run() {
            int num = 2;
            switch (num) {
                case 1:
                    System.out.println("1입니다.");
                    break;
                case 2:
                    System.out.println("2입니다.");
                    break;
                default:
                    System.out.println("기타");
            }
        }
    }
}
