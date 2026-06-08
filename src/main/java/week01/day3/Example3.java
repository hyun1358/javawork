package week01.day3;

/**
 * [학습 예제 3] Week 01 Day 3 — 연산자 종합
 * 
 * [학습 핵심 이론: 자바의 연산자 체계]
 * 4. 논리 연산자 (Logical Operators):
 *    - && (AND - 논리곱): 두 조건이 모두 true일 때만 true 반환.
 *    - || (OR - 논리합): 두 조건 중 하나라도 true이면 true 반환.
 *    - ! (NOT - 논리부정): 단항 연산자로, boolean 상태를 역전시킵니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: 논리 연산자 (&&, ||, !)
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("--- Lab3: 논리 연산자 (&&, ||, !) ---");
        Lab3.run();
        System.out.println("\n[해설] &&(AND)는 둘 다 참일 때, ||(OR)는 하나만 참이어도 참입니다.");
    }

    static class Lab3 {
        static void run() {
            boolean t = true, f = false;
            System.out.println("t && f : " + (t && f));
            System.out.println("t || f : " + (t || f));
            System.out.println("!t     : " + (!t));
        }
    }
}
