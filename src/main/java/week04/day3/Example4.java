package week04.day3;

/**
 * [학습 예제 4] Week 04 Day 3 — 오버로딩(Overloading)의 상세 규칙
 * 
 * [문제별 학습 목표]
 * - Lab4: 매개변수 타입에 따른 동적 메시지 getType (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        // Problem 4: 정수/실수/문자열을 판별하는 getType
        System.out.println("getType(100) 결과: " + getType(100));
        System.out.println("getType(3.14) 결과: " + getType(3.14));
        System.out.println("getType(\"Hello\") 결과: " + getType("Hello"));
    }

    static String getType(int val) { return "정수"; }
    static String getType(double val) { return "실수"; }
    static String getType(String val) { return "문자열"; }
}
