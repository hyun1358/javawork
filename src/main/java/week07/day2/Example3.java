package week07.day2;

import java.util.Scanner;

/**
 * [학습 예제 3] Week 07 Day 2 — Resource 해제와 try-with-resources
 * 
 * [학습 핵심 이론: 자원(Resource) 해제와 현대적 try-with-resources]
 * 2. try-with-resources (Java 7+):
 *    - try 소괄호 `try (Resource res = new Resource())` 안에 `AutoCloseable` 인터페이스를 구현한 자원을 선언하면, 블록 종료 시 자동으로 `.close()`를 호출해 줍니다.
 *    - 기존의 복잡하고 지저분한 finally 수동 close 코드(null 체크 + 중첩 try)를 획기적으로 정돈해 줍니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: try-with-resources 문법을 이용한 자원 해제 리팩토링 (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab3: try-with-resources 문법을 이용한 자원 해제 리팩토링 (Problem 3 연계) ---");
        Lab3.run();
    }

    static class Lab3 {
        static void run() {
            // Problem 3: try-with-resources 리팩토링
            // Scanner는 AutoCloseable을 구현하므로 try 소괄호 안에 넣으면 close() 수동작성이 필요 없습니다.
            try (Scanner sc = new Scanner("자동 해제 데이터")) {
                System.out.println("try-with-resources 구동 데이터: " + sc.next());
                System.out.println("-> [자동화] 블록이 닫히면 자동으로 close()가 백그라운드에서 호출됩니다.");
            } catch (Exception e) {
                System.out.println("에러: " + e.getMessage());
            }
        }
    }
}
