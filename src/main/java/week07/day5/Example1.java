package week07.day5;

/**
 * [학습 예제 1] Week 07 Day 5 — String 클래스와 효율적 가공
 * 
 * [학습 핵심 이론: 실무형 문자열 제어와 성능 최적화]
 * 1. String의 불변성 (Immutability):
 *    - String 객체는 메모리상에서 내부 값이 변경되지 않는 불변성을 가집니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: 문자열 역순 변환 및 회문(Palindrome) 판별 (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: 문자열 역순 변환 및 회문(Palindrome) 판별 (Problem 1 연계) ---");
        Lab1.run();
    }

    static class Lab1 {
        static void run() {
            // Problem 1: 뒤집어서 원본과 똑같은지 회문 판별
            String[] testWords = {"abcba", "hello", "토마토"};
            for (String word : testWords) {
                String reversed = "";
                // 뒤에서부터 글자씩 획득해 뒤집기
                for (int i = word.length() - 1; i >= 0; i--) {
                    reversed += word.charAt(i);
                }
                boolean isPalindrome = word.equals(reversed);
                System.out.printf("원본: \"%s\" | 뒤집힘: \"%s\" -> 회문 여부: %b\n", word, reversed, isPalindrome);
            }
        }
    }
}
