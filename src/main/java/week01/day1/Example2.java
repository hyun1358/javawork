package week01.day1;

/**
 * [학습 예제 2] Week 01 Day 1 — 자바 기초 출력
 * 
 * [학습 핵심 이론: 자바의 출력 스트림과 메소드]
 * 2. 출력 메소드 3대장:
 *    - print(): 데이터를 화면에 단순히 출력합니다. 개행(줄바꿈)이 일어나지 않아 연속적으로 텍스트를 나열할 때 적합합니다.
 *    - println(): 데이터를 출력한 직후 자동으로 개행(\n)을 수행하여 가독성을 높입니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: print의 연속 출력 및 println() 호출을 통한 수동 개행
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("--- Lab2: print vs println ---");
        Lab2.run();
        System.out.println("\n[해설] print()는 줄을 바꾸지 않고 이어서 출력합니다.");
    }

    static class Lab2 {
        static void run() {
            System.out.print("가나다");
            System.out.print("라마바");
            System.out.println(); // 줄바꿈만 수행
        }
    }
}
