package week01.day1;

/**
 * [학습 예제 1] Week 01 Day 1 — 자바 기초 출력
 * 
 * [학습 핵심 이론: 자바의 출력 스트림과 메소드]
 * 1. System 클래스:
 *    - System은 자바의 표준 입출력 및 시스템 정보를 제어하는 대표적인 클래스입니다.
 *    - 이 중 'out' 필드는 표준 출력 스트림(PrintStream 객체)을 가리킵니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: println의 개행 매커니즘 확인
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: println 기본 출력 ---");
        Lab1.run();
        System.out.println("\n[해설] System.out.println()은 출력 후 자동으로 줄을 바꿉니다.");
    }

    static class Lab1 {
        static void run() {
            System.out.println("자바 출력 연습 1");
            System.out.println("자바 출력 연습 2");
        }
    }
}
