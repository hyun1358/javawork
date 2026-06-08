package week03.day4;

/**
 * [학습 예제 4] Week 03 Day 4 — 객체 참조와 병렬 배열
 * 
 * [학습 핵심 이론: 참조 타입 배열 및 병렬 배열 데이터 구조]
 * 4. 병렬 배열 최댓값 추적:
 *    - 가격 배열에서 최댓값의 인덱스(`maxIndex`)를 구한 뒤, 이를 상품명 배열의 인덱스로 활용하여 최고가 상품명을 도출합니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: 병렬 배열에서 최고가 상품명 검색 (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab4: 병렬 배열에서 최고가 상품명 검색 (Problem 4 연계) ---");
        Lab4.run();
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
}
