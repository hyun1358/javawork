package week04.day2;

import java.util.Arrays;

/*
 * [정답 + 해설 2] Week 04 Day 2
 * 문제: 배열을 받아서 모든 원소를 2배로 변경하는 메서드
 */
public class Answer2 {
    // 메인 메서드: 메서드 호출을 통한 참조형 데이터(배열)의 원본 변경 확인
    public static void main(String[] args) {
        // 테스트할 정수 배열 초기화
        int[] myArr = {1, 2, 3, 4, 5};
        // 변경 전 원본 배열 상태 출력
        System.out.println("변경 전: " + Arrays.toString(myArr));

        // doubleArray 메서드 호출. 배열의 주소값이 전달됨.
        doubleArray(myArr); // 배열은 참조가 전달되므로 원본이 바뀝니다.

        // 메서드 호출 후 변경된 원본 배열 상태 출력
        System.out.println("변경 후: " + Arrays.toString(myArr));
    }

    /**
     * 배열의 모든 원소를 2배로 만듭니다.
     *
     * @param arr 참조가 전달되는 배열 매개변수
     */
    public static void doubleArray(int[] arr) {
        // 전달받은 배열을 순회
        for (int i = 0; i < arr.length; i++) {
            // 각 인덱스 위치의 요소 값을 2배로 변경
            // 이는 원본 배열 myArr의 값을 직접 수정하는 것과 동일함
            arr[i] *= 2;
        }
    }
}
