package week03.day1;

import java.util.Scanner;

/**
 * [학습 예제] Week 03 Day 1 — 1차원 배열 기초
 * Lab1~Lab6을 순서대로 실행하며 각 개념을 익히세요.
 * 각 Lab 실행 후 출력된 [해설]을 꼭 읽어보세요.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 03 Day 1 학습 예제 ===\n");

        System.out.println("--- Lab1: 배열 선언과 생성 ---");
        Lab1.run();
        System.out.println("\n[해설] int[] arr = new int[5]; 형식으로 배열을 선언하고 생성합니다. 공간은 0으로 자동 초기화됩니다.\n");

        System.out.println("--- Lab2: 배열 초기화 ({} 사용) ---");
        Lab2.run();
        System.out.println("\n[해설] 선언과 동시에 값을 넣어 초기화할 수 있습니다. 중괄호 {}를 사용합니다.\n");

        System.out.println("--- Lab3: 인덱스로 접근 ---");
        Lab3.run();
        System.out.println("\n[해설] 배열의 인덱스는 0부터 시작하며, arr.length는 배열의 크기를 알려줍니다.\n");

        System.out.println("--- Lab4: for문으로 배열 순회 ---");
        Lab4.run();
        System.out.println("\n[해설] 반복문을 사용하면 배열의 모든 요소를 효율적으로 처리할 수 있습니다.\n");

        System.out.println("--- Lab5: ArrayIndexOutOfBoundsException ---");
        Lab5.run();
        System.out.println("\n[해설] 배열의 범위를 벗어난 인덱스에 접근하면 예외(에러)가 발생합니다. 인덱스 주의!\n");

        System.out.println("--- Lab6: Scanner를 활용한 배열 요소 검색 ---");
        Lab6.run();
        System.out.println("\n[해설] Scanner로 입력받은 값을 배열 전체를 순회하며 탐색할 수 있습니다.\n");
    }

    static class Lab1 {
        static void run() {
            int[] arr = new int[3];
            System.out.println("arr[0]: " + arr[0]); // 0
            System.out.println("arr[1]: " + arr[1]); // 0
        }
    }

    static class Lab2 {
        static void run() {
            int[] scores = {10, 20, 30, 40, 50};
            System.out.println("첫 번째 값: " + scores[0]);
            System.out.println("세 번째 값: " + scores[2]);
        }
    }

    static class Lab3 {
        static void run() {
            int[] data = new int[5];
            System.out.println("배열 크기: " + data.length);
            data[data.length - 1] = 100; // 마지막 인덱스
            System.out.println("마지막 인덱스 값: " + data[4]);
        }
    }

    static class Lab4 {
        static void run() {
            int[] numbers = {1, 2, 3, 4, 5};
            for (int i = 0; i < numbers.length; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
        }
    }

    static class Lab5 {
        static void run() {
            int[] smallArr = new int[3];
            try {
                System.out.println(smallArr[3]); // 고의적으로 범위를 벗어남
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("예외 발생: " + e.getMessage());
            }
        }
    }

    static class Lab6 {
        static void run() {
            // Scanner를 활용한 배열 요소 순회 검색
            int[] numbers = {10, 20, 30, 40, 50};
            String inputSource = "30\n";
            Scanner sc = new Scanner(inputSource);
            System.out.println("검색할 정수를 입력해 주세요 (시뮬레이션 입력: 30): ");
            int target = sc.nextInt();
            
            boolean found = false;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == target) {
                    System.out.println("배열의 인덱스 " + i + "에서 값 " + target + "을(를) 찾았습니다.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("배열에서 값을 찾지 못했습니다.");
            }
            sc.close();
        }
    }
}
