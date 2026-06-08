package week01.day1;

/**
 * [학습 예제 3] Week 01 Day 1 — 자바 기초 출력
 * 
 * [학습 핵심 이론: 자바의 출력 스트림과 메소드]
 * 2. 출력 메소드 3대장:
 *    - printf(): C언어 스타일의 서식 지정자(%d, %s, %f 등)를 사용하여 정교한 텍스트 템플릿을 완성하고 출력합니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: 서식 지정자(%s, %d, %n)를 활용한 템플릿 출력
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("--- Lab3: printf 형식 지정 출력 ---");
        Lab3.run();
        System.out.println("\n[해설] %d(정수), %s(문자열), %f(실수) 등을 사용하여 원하는 형식을 만듭니다.");
    }

    static class Lab3 {
        static void run() {
            int count = 5;
            String item = "사과";
            System.out.printf("%s %d개가 있습니다.%n", item, count);
        }
    }
}
