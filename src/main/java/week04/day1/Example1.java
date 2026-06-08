package week04.day1;

/**
 * [학습 예제 1] Week 04 Day 1 — 메서드 정의와 호출
 * 
 * [학습 핵심 이론: 코드 재사용의 기본 - 메서드]
 * 1. 메서드(Method)의 핵심 구성 요소:
 *    - 선언부(Header): 반환 타입(Return Type), 메서드 이름, 매개변수 목록(Parameter List)으로 구성됩니다.
 *    - 구현부(Body): 실행할 자바 코드 블록을 작성하며, 반환 타입이 void가 아니면 반드시 `return`문으로 결과값을 제공해야 합니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: 기본 메서드 선언과 호출 (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        // Problem 1: "안녕하세요!"를 출력하는 메서드 정의 및 호출
        printHello();
    }

    static void printHello() {
        System.out.println("안녕하세요!");
    }
}
