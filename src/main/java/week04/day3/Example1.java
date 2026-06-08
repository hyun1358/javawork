package week04.day3;

/**
 * [학습 예제 1] Week 04 Day 3 — 오버로딩(Overloading)의 상세 규칙
 * 
 * [학습 핵심 이론: 컴파일러의 메서드 시그니처 매칭 원리]
 * 1. 메서드 시그니처 (Method Signature):
 *    - 메서드 이름 + 매개변수 개수, 순서, 타입으로 구성되며, 반환 타입(Return Type)은 오버로딩 성립 조건에 전혀 관여하지 않습니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: 다양한 기본형 출력 오버로딩 (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        // Problem 1: int, double, String뿐 아니라 char, boolean을 받아 출력하는 print 구현
        print(100);
        print(3.14);
        print("자바 공부 중");
        print('A');
        print(true);
    }

    static void print(int val) { System.out.println("정수: " + val); }
    static void print(double val) { System.out.println("실수: " + val); }
    static void print(String val) { System.out.println("문자열: " + val); }
    static void print(char val) { System.out.println("문자: " + val); }
    static void print(boolean val) { System.out.println("논리값: " + val); }
}
