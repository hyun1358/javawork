package week01.day4;

/**
 * [학습 예제 4] Week 01 Day 4 — 형변환 (Casting)과 데이터 파싱
 * 
 * [학습 핵심 이론: 데이터 타입 변환 매커니즘]
 * 3. 문자(char)와 아스키코드(ASCII/Unicode) 변환:
 *    - 자바의 char 타입은 내부적으로 2바이트 유니코드 정수로 저장됩니다.
 *    - 따라서 int형으로 변환하면 아스키/유니코드 번호(예: 'A' = 65)를 얻을 수 있고, 반대로 int형 번호에 (char)를 씌우면 문자로 복원됩니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: 문자와 숫자의 변환
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("--- Lab4: 문자와 숫자의 변환 ---");
        Lab4.run();
        System.out.println("\n[해설] char는 유니코드 숫자로 관리되므로 int로 변환이 쉽습니다.");
    }

    static class Lab4 {
        static void run() {
            char c = 'A';
            int n = c; // 자동
            System.out.println("'A' -> " + n);
            System.out.println("66 -> " + (char) 66);
        }
    }
}
