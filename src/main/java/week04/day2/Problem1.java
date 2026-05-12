package week04.day2;

import java.util.Arrays;

/**
 * [연습 문제 1] Week 04 Day 2
 * <p>
 * 문제: int형 배열을 매개변수로 받아 모든 원소의 값을 2배로 변경하는
 * doubleAll 메서드를 작성하고, main에서 원본 배열이 변경되었는지 확인하세요.
 * <p>
 * 난이도: ★★☆☆☆
 */
public class Problem1 {
    public static void main(String[] args) {
        int[] data = {1, 3, 5, 7, 9};

        // TODO: doubleAll 메서드를 호출하여 data 배열의 모든 원소를 2배로 만드세요

        System.out.println("결과 배열: " + Arrays.toString(data));
    }

    // TODO: int[]를 받아 각 원소에 2를 곱해 수정하는 doubleAll 메서드를 작성하세요
}
