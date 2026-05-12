package week04.day2;

import java.util.Arrays;

/*
 * [정답 + 해설 1] Week 04 Day 2
 * 문제: 배열 원소 2배로 변경하는 doubleAll 메서드 작성
 */
public class Answer1 {
    public static void main(String[] args) {
        int[] data = {1, 3, 5, 7, 9};

        // 배열은 참조형이므로 메서드 안에서 원본이 직접 수정됩니다.
        doubleAll(data);

        System.out.println("결과 배열: " + Arrays.toString(data));
    }

    public static void doubleAll(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
    }
}
/*
 * [해설]
 * - 기본형 매개변수와 달리 배열은 '주소값'이 전달됩니다.
 * - 메서드 내부의 arr[i] 수정은 곧 main의 data[i] 수정을 의미합니다.
 */
