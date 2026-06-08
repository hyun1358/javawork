package week04.day5;

/**
 * [학습 예제 1] Week 04 Day 5 — 메서드 설계와 문서화
 * 
 * [학습 핵심 이론: 클린 코드와 메서드 문서화 표준]
 * 1. 단일 책임 원칙 (Single Responsibility Principle):
 *    - 하나의 메서드는 오직 '한 가지 역할'만 수행해야 하며, 코드 중복이 발생하면 즉시 전용 메서드로 분리(Extract Method)해 리팩토링합니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: 공통 출력 코드를 분리하는 메서드 리팩토링 (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        printStudentCard("홍길동");
    }

    public static void printHeader(String title) {
        System.out.println("---------");
        System.out.println(title);
        System.out.println("---------");
    }

    public static void printData(String label, String value) {
        System.out.println(label + ": " + value);
    }

    public static void printFooter() {
        System.out.println("---------");
    }

    public static void printStudentCard(String studentName) {
        printHeader("학생 정보");
        printData("이름", studentName);
        printFooter();
    }
}
