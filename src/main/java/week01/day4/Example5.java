package week01.day4;

/**
 * [학습 예제 5] Week 01 Day 4 — 형변환 (Casting)과 데이터 파싱
 * 
 * [학습 핵심 이론: 데이터 타입 변환 매커니즘]
 * 4. 문자열(String)과 숫자의 상호 변환:
 *    - 문자열 "100"은 텍스트일 뿐이므로 연산이 불가능합니다.
 *    - `Integer.parseInt(문자열)`을 통해 정수로 변환하여 연산할 수 있게 합니다.
 *    - 숫자를 문자열로 변환할 때는 `String.valueOf(숫자)`를 주로 사용합니다.
 * 
 * [문제별 학습 목표]
 * - Lab5: 문자열과 숫자의 변환
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("--- Lab5: 문자열과 숫자의 변환 ---");
        Lab5.run();
        System.out.println("\n[해설] Integer.parseInt(), String.valueOf() 등을 사용합니다.");
    }

    static class Lab5 {
        static void run() {
            String s = "100";
            int n = Integer.parseInt(s);
            String s2 = String.valueOf(n);
            System.out.println("변환된 숫자 + 200: " + (n + 200));
            System.out.println("변환된 문자열: " + s2);
        }
    }
}
