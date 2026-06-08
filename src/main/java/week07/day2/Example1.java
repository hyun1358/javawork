package week07.day2;

import java.util.Scanner;

/**
 * [학습 예제 1] Week 07 Day 2 — Resource 해제와 try-with-resources
 * 
 * [학습 핵심 이론: 자원(Resource) 해제와 현대적 try-with-resources]
 * 1. finally 블록의 사명:
 *    - 외부 리소스(Scanner, DB Connection, File I/O 등)는 가비지 컬렉터(GC)가 수거하지 못하므로 직접 해제해 주어야 합니다.
 *    - `finally` 블록은 예외 발생 여부와 전혀 무관하게 반드시 최종 실행되므로 자원 해제 코드를 두기에 가장 안전한 구역입니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: finally 블록을 이용한 명시적인 Scanner 자원 해제 (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: finally 블록을 이용한 명시적인 Scanner 자원 해제 (Problem 1 연계) ---");
        Lab1.run();
    }

    static class Lab1 {
        static void run() {
            // Problem 1: finally에서 Scanner 수동 닫기
            Scanner sc = null;
            try {
                sc = new Scanner("임시 입력 소스");
                System.out.println("Scanner 자원을 획득하고 데이터를 읽습니다: " + sc.next());
            } catch (Exception e) {
                System.out.println("에러 발생: " + e.getMessage());
            } finally {
                // null 체크 후 안전하게 close 호출
                if (sc != null) {
                    sc.close();
                    System.out.println("-> [finally] Scanner 자원이 성공적으로 회수되었습니다.");
                }
            }
        }
    }
}
