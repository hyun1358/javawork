package week01.day1;

/**
 * [학습 예제 5] Week 01 Day 1 — 자바 기초 출력
 * 
 * [학습 핵심 이론: 자바의 출력 스트림과 메소드]
 * 3. Lab 학습 가이드:
 *    - Lab5: 자바 애플리케이션의 유일한 진입점(Entry Point)인 main 메소드의 구조 이해
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println("--- Lab5: 실행 구조 확인 ---");
        Lab5.run();
        System.out.println("\n[해설] 모든 자바 프로그램은 main 메서드에서 시작됩니다.");
    }

    static class Lab5 {
        static void run() {
            System.out.println("public class와 public static void main의 관계를 기억하세요.");
        }
    }
}
