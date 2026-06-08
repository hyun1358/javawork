package week01.day2;

/**
 * [학습 예제 4] Week 01 Day 2 — 변수와 기본 자료형 및 데이터 특징
 * 
 * [학습 핵심 이론: 변수 선언과 메모리 자료형]
 * 4. char와 유니코드 숫자 매핑:
 *    - char는 문자뿐만 아니라 해당하는 유니코드 정수값(예: 'A' = 65)을 직접 할당받아 문자 형태로 다룰 수도 있습니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: 문자형 (char)의 문자 대입 vs 숫자 대입
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("--- Lab4: 문자형 (char)의 문자 대입 vs 숫자 대입 ---");
        Lab4.run();
        System.out.println("\n[해설] char 변수에 아스키/유니코드 번호(65)를 넣어도 문자 'A'로 자동 변환되어 매핑 출력됩니다.");
    }

    static class Lab4 {
        static void run() {
            char grade1 = 'A';
            char grade2 = 65; // 문자 'A'의 아스키 정수값
            System.out.println("문자로 넣은 char: " + grade1); // A
            System.out.println("정수로 넣은 char: " + grade2); // A
        }
    }
}
