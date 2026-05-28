package week03.day1;

import java.util.Scanner;

/**
 * [학습 예제] Week 03 Day 1 — 1차원 배열 기초
 * 
 * [학습 핵심 이론: 순차 데이터 구조 - 배열]
 * 1. 배열(Array)의 메모리 특징:
 *    - 같은 타입의 변수들을 연속된 메모리 공간에 나열한 고정 크기 자료구조입니다.
 *    - 선언 시 크기가 고정되며, 런타임에 동적으로 크기를 늘리거나 줄일 수 없습니다.
 * 
 * 2. 힙(Heap) 메모리 할당:
 *    - 배열 변수는 참조 타입으로, 실제 데이터는 힙(Heap) 메모리에 생성되고 변수(Stack)는 그 주소값만 보관합니다.
 *    - 초기화를 생략하면 각 자료형의 기본값(정수: 0, 실수: 0.0, 참조형: null)으로 자동 세팅됩니다.
 * 
 * 3. 인덱스(Index) 바운드:
 *    - 인덱스는 0부터 (배열크기 - 1)까지 존재합니다. 이 범위를 벗어나면 `ArrayIndexOutOfBoundsException`이 발생합니다.
 * 
 * [연습 문제 1~5 해결을 위한 필수 핵심 기법]
 * - 합계와 평균 구하기: 배열을 순회하며 누적 합(sum)을 구하고, 형변환 `(double)`을 사용해 정확한 평균을 계산합니다.
 * - 최댓값 찾기: 기준값을 첫 번째 요소(`arr[0]`)로 설정한 후, 반복문을 돌며 더 큰 값이 나오면 기준값을 갱신합니다.
 * - 역순 출력: 인덱스를 `arr.length - 1`부터 `0`까지 역방향으로 1씩 감소시키며 순회합니다.
 * - 특정 값 검색: boolean flag 변수를 활용하여 순회 도중 값을 찾았는지 여부를 기록합니다.
 * - 짝수 판별: `% 2 == 0` 연산자를 배열 요소에 적용하여 조건에 맞는 값만 골라 출력합니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 03 Day 1 학습 예제 ===\n");

        System.out.println("--- Lab1: 배열 선언과 생성 ---");
        Lab1.run();

        System.out.println("\n--- Lab2: 배열 초기화 ({} 사용) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: 인덱스로 접근 및 .length ---");
        Lab3.run();

        System.out.println("\n--- Lab4: 배열 합계와 평균 구하기 (Problem 1 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: 배열에서 최댓값 찾기 (Problem 2 연계) ---");
        Lab5.run();

        System.out.println("\n--- Lab6: 배열 역순 출력하기 (Problem 3 연계) ---");
        Lab6.run();

        System.out.println("\n--- Lab7: Scanner를 활용한 배열 요소 검색 (Problem 4 연계) ---");
        Lab7.run();

        System.out.println("\n--- Lab8: 배열에서 짝수만 출력하기 (Problem 5 연계) ---");
        Lab8.run();

        System.out.println("\n--- Lab9: ArrayIndexOutOfBoundsException 예외 방지 ---");
        Lab9.run();
    }

    static class Lab1 {
        static void run() {
            // 크기 3의 int 배열 생성 (0으로 자동 초기화됨)
            int[] arr = new int[3];
            System.out.println("arr[0]: " + arr[0]); 
            System.out.println("arr[1]: " + arr[1]); 
        }
    }

    static class Lab2 {
        static void run() {
            // 선언과 동시에 중괄호 {}를 사용해 초기화
            int[] scores = {10, 20, 30, 40, 50};
            System.out.println("첫 번째 값: " + scores[0]);
            System.out.println("세 번째 값: " + scores[2]);
        }
    }

    static class Lab3 {
        static void run() {
            int[] data = new int[5];
            System.out.println("배열 크기: " + data.length);
            // 마지막 인덱스는 항상 length - 1 입니다.
            data[data.length - 1] = 100; 
            System.out.println("마지막 인덱스(4) 값: " + data[4]);
        }
    }

    static class Lab4 {
        static void run() {
            // Problem 1: 배열 요소의 합계와 평균 구하기
            int[] values = {88, 92, 79, 95, 80};
            int sum = 0;
            for (int i = 0; i < values.length; i++) {
                sum += values[i];
            }
            // 평균 계산 시 정수 나눗셈의 소수점 손실을 방지하기 위해 double형으로 변환합니다.
            double avg = (double) sum / values.length;
            System.out.println("배열 요소들의 합계: " + sum);
            System.out.println("배열 요소들의 평균: " + avg);
        }
    }

    static class Lab5 {
        static void run() {
            // Problem 2: 최댓값 탐색 알고리즘
            int[] arr = {12, 45, 7, 23, 56, 32};
            int max = arr[0]; // 첫 번째 요소를 최댓값 후보로 설정
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i]; // 더 큰 값을 찾으면 최댓값 갱신
                }
            }
            System.out.println("배열 내 최댓값: " + max);
        }
    }

    static class Lab6 {
        static void run() {
            // Problem 3: 역방향 순회(역순 출력)
            int[] arr = {1, 2, 3, 4, 5};
            System.out.print("역순 출력 결과: ");
            // 인덱스를 arr.length - 1부터 0까지 감소시키며 반복합니다.
            for (int i = arr.length - 1; i >= 0; i--) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    static class Lab7 {
        static void run() {
            // Problem 4: boolean flag를 활용한 값 검색 및 존재 여부 출력
            int[] numbers = {10, 20, 30, 40, 50};
            String inputSource = "30\n";
            Scanner sc = new Scanner(inputSource);
            System.out.println("검색할 정수를 입력하세요 (예제 입력: 30): ");
            int target = sc.nextInt();
            
            boolean found = false; // 발견 여부를 저장하는 flag 변수
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == target) {
                    found = true;
                    break; // 찾았으므로 더 이상의 루프는 생략
                }
            }
            if (found) {
                System.out.println(target + "은(는) 배열에 있습니다.");
            } else {
                System.out.println(target + "은(는) 배열에 없습니다.");
            }
            sc.close();
        }
    }

    static class Lab8 {
        static void run() {
            // Problem 5: 특정 조건(짝수)에 부합하는 배열 요소만 필터링 출력
            int[] arr = {10, 15, 20, 25, 30, 35, 40};
            System.out.print("짝수만 출력: ");
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 0) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }
    }

    static class Lab9 {
        static void run() {
            int[] smallArr = new int[3];
            try {
                System.out.println(smallArr[3]); // 고의로 ArrayIndexOutOfBoundsException 유발
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("안전 예외 처리: 배열 범위를 벗어났습니다. (" + e.getMessage() + ")");
            }
        }
    }
}
