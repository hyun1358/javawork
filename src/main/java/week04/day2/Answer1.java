package week04.day2;

import java.util.Arrays;

/*
 * [정답 + 해설 1] Week 04 Day 2
 * 문제: 배열 원소 2배로 변경하는 doubleAll 메서드 작성
 */
public class Answer1 {
    // 메인 메서드: 배열을 메서드에 전달하여 값이 어떻게 변하는지 확인
    public static void main(String[] args) {
        // 정수형 배열 생성 및 초기화
        int[] data = {1, 3, 5, 7, 9};

        // 배열은 참조형이므로 메서드 안에서 원본이 직접 수정됩니다.
        // data 배열의 메모리 주소를 doubleAll 메서드에 전달
        doubleAll(data);

        // 메서드 호출 후, 원본 배열의 값이 2배로 변경되었는지 확인 및 출력
        System.out.println("결과 배열: " + Arrays.toString(data));
    }

    // doubleAll 메서드: 매개변수로 배열의 참조(주소)를 받아 모든 요소를 2배로 만듦
    public static void doubleAll(int[] arr) {
        // 배열의 첫 번째 요소부터 마지막 요소까지 순회
        for (int i = 0; i < arr.length; i++) {
            // 원본 배열(arr가 가리키는 메모리)의 값을 직접 2배로 곱하여 다시 저장
            arr[i] *= 2;
        }
    }
}
/*
 * [해설]
 * - 기본형 매개변수와 달리 배열은 '주소값'이 전달됩니다.
 * - 메서드 내부의 arr[i] 수정은 곧 main의 data[i] 수정을 의미합니다.
 */
