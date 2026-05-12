package week04.day2;

import java.util.Arrays;

/*
 * [정답 + 해설 2] Week 04 Day 2
 * 문제: 배열을 받아서 모든 원소를 2배로 변경하는 메서드
 */
public class Answer2 {
    public static void main(String[] args) {
        int[] myArr = {1, 2, 3, 4, 5};
        System.out.println("변경 전: " + Arrays.toString(myArr));

        doubleArray(myArr); // 배열은 참조가 전달되므로 원본이 바뀝니다.

        System.out.println("변경 후: " + Arrays.toString(myArr));
    }

    /**
     * 배열의 모든 원소를 2배로 만듭니다.
     *
     * @param arr 참조가 전달되는 배열 매개변수
     */
    public static void doubleArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
    }
}
