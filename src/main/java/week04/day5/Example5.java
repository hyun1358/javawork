package week04.day5;

/**
 * [학습 예제 5] Week 04 Day 5 — 메서드 설계와 문서화
 * 
 * [학습 핵심 이론: 클린 코드와 메서드 문서화 표준]
 * 5. String 가공 유틸리티:
 *    - `.trim()`은 앞뒤 공백을 자르고, `.toUpperCase()`는 알파벳을 소문자에서 대문자로 통일해 데이터 정형화를 돕습니다.
 * 
 * [문제별 학습 목표]
 * - Lab5: 문자열 앞뒤 공백 제거 및 대문자 정규화 유틸리티 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        String formatted = cleanString("  java  ");
        System.out.println("정규화 전: \"  java  \" -> 정규화 후: \"" + formatted + "\"");
    }

    public static String cleanString(String s) {
        if (s == null) {
            return "";
        }
        // trim()으로 앞뒤 공백을 자르고, toUpperCase()로 대문자 치환
        return s.trim().toUpperCase();
    }
}
