package week03.day4;

import java.util.Arrays;

/**
 * [학습 예제] Week 03 Day 4 — 객체 참조와 병렬 배열 (문자열 정렬, 병렬 데이터 매핑, equals 검색, 역순 출력)
 * 
 * [학습 핵심 이론: 참조 타입 배열 및 병렬 배열 데이터 구조]
 * 1. String 배열의 특징:
 *    - String은 참조 타입이므로, String[] 배열 내부의 각 방은 실제 문자열 객체의 주소값을 저장합니다.
 *    - 문자열을 정렬할 때는 `Arrays.sort()`를 사용하며, 알파벳 사전 순(Lexicographical order, 아스키코드 순)으로 정렬됩니다. (대문자가 소문자보다 먼저 나옴)
 * 
 * 2. 문자열 내용 비교 (`.equals()`):
 *    - 참조형 변수나 배열 요소의 값을 비교할 때는 `==`(주소 비교) 대신 반드시 `.equals()` 메서드를 사용해 내용 자체를 비교해야 합니다.
 * 
 * 3. 병렬 배열(Parallel Array):
 *    - 논리적으로 연관된 여러 속성 데이터를 동일한 크기의 여러 1차원 배열로 나누어, 인덱스 `i`를 매개체로 연결하는 실무 기본 매핑 기법입니다.
 *    - 예: `names[i]`의 점수는 `scores[i]`에 매칭됩니다.
 * 
 * 4. 병렬 배열 최댓값 추적:
 *    - 가격 배열에서 최댓값의 인덱스(`maxIndex`)를 구한 뒤, 이를 상품명 배열의 인덱스로 활용하여 최고가 상품명을 도출합니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Week 03 Day 4 학습 예제 ===\n");

        System.out.println("--- Lab1: 문자열 배열 정렬 (Problem 1 연계) ---");
        Lab1.run();

        System.out.println("\n--- Lab2: 병렬 배열을 이용한 성적 출력 (Problem 2 연계) ---");
        Lab2.run();

        System.out.println("\n--- Lab3: 문자열 배열에서 특정 문자열 검색 (.equals() 활용) (Problem 3 연계) ---");
        Lab3.run();

        System.out.println("\n--- Lab4: 병렬 배열에서 최고가 상품명 검색 (Problem 4 연계) ---");
        Lab4.run();

        System.out.println("\n--- Lab5: 문자열 배열 역순 출력 (Problem 5 연계) ---");
        Lab5.run();

        System.out.println("\n--- Lab6: 1차원 배열 이진 탐색 (Arrays.binarySearch) ---");
        Lab6.run();
    }

    static class Lab1 {
        static void run() {
            // Problem 1: 5가지 과일 이름 배열 선언 및 알파벳순 정렬
            String[] fruits = {"Pineapple", "Apple", "Orange", "Banana", "Cherry"};
            System.out.println("정렬 전: " + Arrays.toString(fruits));
            
            Arrays.sort(fruits);
            System.out.println("정렬 후: " + Arrays.toString(fruits));
        }
    }

    static class Lab2 {
        static void run() {
            // Problem 2: 이름 배열과 점수 배열 매핑 출력
            String[] names = {"Kim", "Lee", "Park"};
            int[] scores = {80, 95, 70};

            for (int i = 0; i < names.length; i++) {
                System.out.printf("%s의 점수는 %d점입니다.\n", names[i], scores[i]);
            }
        }
    }

    static class Lab3 {
        static void run() {
            // Problem 3: equals()를 활용한 문자열 탐색 및 인덱스 출력
            String[] names = {"Kim", "Lee", "Park", "Choi"};
            String target = "Park";
            int index = -1; // 찾지 못한 경우를 기본값으로 설정

            for (int i = 0; i < names.length; i++) {
                // 중요: 문자열 비교 시 절대 == 를 쓰지 않고 .equals()를 사용합니다.
                if (names[i].equals(target)) {
                    index = i;
                    break; // 찾았으므로 즉시 중단
                }
            }

            if (index != -1) {
                System.out.printf("문자열 \"%s\"은(는) 배열의 %d번째 인덱스에 존재합니다.\n", target, index);
            } else {
                System.out.printf("문자열 \"%s\"은(는) 배열에 없습니다.\n", target);
            }
        }
    }

    static class Lab4 {
        static void run() {
            // Problem 4: 병렬 배열에서 최댓값 위치를 기반으로 다른 속성 매핑
            String[] products = {"마우스", "키보드", "모니터"};
            int[] prices = {15000, 35000, 150000};

            int maxPrice = prices[0];
            int maxIndex = 0; // 최고가 가격의 인덱스 기록

            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > maxPrice) {
                    maxPrice = prices[i];
                    maxIndex = i; // 최고가 인덱스 갱신
                }
            }

            System.out.println("가장 비싼 상품명: " + products[maxIndex]);
            System.out.println("가장 비싼 상품 가격: " + prices[maxIndex] + "원");
        }
    }

    static class Lab5 {
        static void run() {
            // Problem 5: String 배열 역순 출력
            String[] alphabet = {"A", "B", "C", "D"};
            System.out.print("역순 출력 결과: ");
            for (int i = alphabet.length - 1; i >= 0; i--) {
                System.out.print(alphabet[i] + " ");
            }
            System.out.println();
        }
    }

    static class Lab6 {
        static void run() {
            // 이진 탐색은 정렬된 배열에서만 올바르게 동작합니다.
            int[] nums = {10, 20, 30, 40, 50};
            int index = Arrays.binarySearch(nums, 30);
            System.out.println("이진 탐색 30의 인덱스 위치: " + index);
        }
    }
}
