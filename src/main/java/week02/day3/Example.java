package week02.day3;

import java.util.Scanner;

/**
 * [학습 예제] Week 02 Day 3 — for 반복문
 * Lab1~Lab6을 순서대로 실행하며 각 개념을 익히세요.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 02 Day 3 학습 예제 ===\n");

        System.out.println("--- Lab1: 기본 for 문 구조 ---");
        Lab1.run();
        System.out.println("\n[해설] for(초기화; 조건식; 증감식) 순서로 작동합니다.\n");

        System.out.println("--- Lab2: 1~N 합계 구하기 ---");
        Lab2.run();
        System.out.println("\n[해설] 반복문 밖에서 변수를 선언하고, 안에서 누적시키는 패턴을 기억하세요.\n");

        System.out.println("--- Lab3: 중첩 for 문 (구구단) ---");
        Lab3.run();
        System.out.println("\n[해설] 바깥쪽 for 문이 한 번 돌 때, 안쪽 for 문은 전체를 다 돕니다.\n");

        System.out.println("--- Lab4: 역순 반복 ---");
        Lab4.run();
        System.out.println("\n[해설] i-- 를 사용하여 큰 수에서 작은 수로 내려올 수 있습니다.\n");

        System.out.println("--- Lab5: 향상된 for-each 문 (맛보기) ---");
        Lab5.run();
        System.out.println("\n[해설] 배열이나 컬렉션의 모든 요소를 순차적으로 꺼낼 때 매우 편리합니다.\n");

        System.out.println("--- Lab6: Scanner를 활용한 사용자 입력 ---");
        Lab6.run();
        System.out.println("\n[해설] Scanner 클래스를 이용해 사용자로부터 정수를 입력받을 수 있습니다.\n");
    }

    static class Lab1 {
        static void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("안녕하세요 " + i);
            }
        }
    }

    static class Lab2 {
        static void run() {
            int n = 100;
            int total = 0;
            for (int i = 1; i <= n; i++) {
                total += i;
            }
            System.out.println("1부터 " + n + "까지의 합: " + total);
        }
    }

    static class Lab3 {
        static void run() {
            // 2단부터 3단까지만 예시
            for (int dan = 2; dan <= 3; dan++) {
                System.out.println("[" + dan + "단]");
                for (int i = 1; i <= 9; i++) {
                    System.out.println(dan + " * " + i + " = " + (dan * i));
                }
                System.out.println();
            }
        }
    }

    static class Lab4 {
        static void run() {
            System.out.print("카운트다운: ");
            for (int i = 5; i >= 1; i--) {
                System.out.print(i + " ");
            }
            System.out.println("발사!");
        }
    }

    static class Lab5 {
        static void run() {
            int[] scores = {90, 80, 100};
            for (int score : scores) {
                System.out.println("점수: " + score);
            }
        }
    }

    static class Lab6 {
        static void run() {
            // Scanner를 사용하여 콘솔 입력을 받습니다.
            String inputSource = "5\n"; // 콘솔 입력을 시뮬레이션하기 위한 임의의 입력 데이터
            Scanner sc = new Scanner(inputSource);
            System.out.println("정수를 입력해 주세요 (시뮬레이션 입력: 5): ");
            int value = sc.nextInt();
            System.out.println("입력된 값: " + value);
            sc.close();
        }
    }
}
