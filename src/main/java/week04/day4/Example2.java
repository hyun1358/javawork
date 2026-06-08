package week04.day4;

/**
 * [학습 예제 2] Week 04 Day 4 — 재귀 호출(Recursion)의 원리와 활용
 * 
 * [학습 핵심 이론: 재귀 설계의 핵심 원칙]
 * 2. Recursive Step (재귀 단계):
 *    - 예: 첫 글자를 떼어 맨 뒤로 보내고, 나머지 문자열을 다시 재귀적으로 뒤집어 결합
 * 
 * [문제별 학습 목표]
 * - Lab2: 재귀적 문자열 역순 뒤집기 (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        String original = "Hello";
        String reversed = reverse(original);
        System.out.println("원본 문자열: " + original);
        System.out.println("뒤집힌 결과: " + reversed);
    }

    public static String reverse(String s) {
        // Base Case
        if (s.isEmpty()) {
            return s;
        }
        return reverse(s.substring(1)) + s.charAt(0);
    }
}
