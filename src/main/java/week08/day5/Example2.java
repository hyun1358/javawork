package week08.day5;

import java.util.Arrays;

/**
 * [학습 예제 2] Week 08 Day 5 — 제네릭(Generics) 심화와 와일드카드
 * 
 * [학습 핵심 이론: 컴파일 타임 타입 안전성 보장 - 제네릭]
 * 2. 제네릭 메서드 (Generic Method):
 *    - 반환 타입 앞에 `<T>`를 선언하여 메서드 호출 시점에 유동적으로 매개변수나 반환 형식을 결정하는 메서드입니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: generic 메서드 <T> swap 구현 및 두 요소 교환 (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab2: generic 메서드 <T> swap 구현 및 두 요소 교환 (Problem 2 연계) ---");
        Lab2.run();
    }

    // Problem 2: 제네릭 메서드 swap
    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static class Lab2 {
        static void run() {
            String[] fruits = {"바나나", "사과", "포도", "딸기"};
            System.out.println("교환 전 배열: " + Arrays.toString(fruits));
            
            // 0번 "바나나"와 3번 "딸기" 교환
            swap(fruits, 0, 3);
            System.out.println("교환 후 배열: " + Arrays.toString(fruits));
        }
    }
}
