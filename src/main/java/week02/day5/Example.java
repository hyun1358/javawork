package week02.day5;

import java.util.Scanner;

/**
 * [학습 예제] Week 02 Day 5 — break와 continue 활용
 * 
 * [학습 핵심 이론: 반복 제어 실무 패턴]
 * 1. break를 통한 조건 조기 탈출:
 *    - 무한 루프 내에서 센티널(Sentinel) 값을 만나거나 비즈니스 검증 오류가 발생했을 때 즉각 루프를 정지시킵니다.
 * 
 * 2. continue를 이용한 무효 데이터 필터링:
 *    - 홀수만 건너뛰거나 특정 조건의 가짜 데이터를 무시하고 다음 루프로 진행할 때 효과적입니다.
 * 
 * 3. 중첩 반복문 이름(Label) 지정:
 *    - `outer:`와 같은 이름표를 사용해 내부 깊숙한 루프에서 바깥 루프 전체를 제어하는 고급 제어 흐름 기법을 실습합니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: 별 패턴 만들기 (중첩 for) ===");
        Lab1.run();

        System.out.println("\n=== Lab2: 레이블(Label) break ===");
        Lab2.run();

        System.out.println("\n=== Lab3: Scanner와 while(true) 메뉴 루프 ===");
        Lab3.run();
    }

    static class Lab1 {
        static void run() {
            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }

    static class Lab2 {
        static void run() {
            outer:
            // 레이블 이름
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {
                    if (i == 2 && j == 2) break outer; // 바깥쪽 루프까지 한 번에 탈출
                    System.out.println("i=" + i + ", j=" + j);
                }
            }
        }
    }

    static class Lab3 {
        static void run() {
            // Scanner를 활용한 반복문 메뉴 처리 시뮬레이션
            String inputs = "1\n2\n"; // 자동 실행을 위한 시뮬레이션 입력값
            Scanner sc = new Scanner(inputs);
            
            while (true) {
                System.out.println("[메뉴] 1. 안녕하세요 출력, 2. 루프 종료");
                int choice = sc.nextInt();
                if (choice == 1) {
                    System.out.println("안녕하세요!");
                } else if (choice == 2) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }
            }
            sc.close();
        }
    }
}
