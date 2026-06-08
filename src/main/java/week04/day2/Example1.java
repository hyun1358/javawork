package week04.day2;

import java.util.Arrays;

/**
 * [학습 예제 1] Week 04 Day 2 — 메서드 매개변수 심화
 * 
 * [학습 핵심 이론: Call by Value 매커니즘 및 다형적 호출]
 * 2. 참조형 매개변수 (Reference Type Parameter):
 *    - 객체의 주소(참조값)가 복사되어 전달됩니다. 복사된 주소를 통해 동일한 힙(Heap) 영역의 객체를 가리키므로, 메서드 내부에서 배열의 요소를 수정하면 호출 측의 원본 배열도 변경을 겪습니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: 참조형 매개변수 조작 - 배열 요소 2배로 변경 (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        // Problem 1: int[]를 받아 모든 원소를 2배로 만드는 doubleAll 구현
        int[] data = {1, 3, 5, 7, 9};
        System.out.println("원래 배열: " + Arrays.toString(data));
        
        doubleAll(data);
        System.out.println("doubleAll 호출 후 원본 배열: " + Arrays.toString(data));
    }

    static void doubleAll(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * 2; // 참조 주소를 따라가 Heap의 원본 값을 직접 2배로 갱신
        }
    }
}
