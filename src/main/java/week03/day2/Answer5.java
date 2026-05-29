package week03.day2;

import java.util.Arrays;

public class Answer5 {
    // 메인 메서드: 배열의 요소를 왼쪽으로 한 칸씩 회전하는 로직 실행
    public static void main(String[] args) {
        // 초기 배열 생성
        int[] arr = {1, 2, 3, 4, 5};
        // 배열의 가장 첫 번째 값을 임시 변수에 저장 (나중에 맨 뒤로 이동)
        int first = arr[0];

        // 두 번째 요소부터 마지막 요소까지를 한 칸씩 앞으로 당김
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        // 저장해둔 첫 번째 값을 배열의 가장 마지막 위치에 삽입
        arr[arr.length - 1] = first;

        // 회전이 완료된 배열 출력
        System.out.println(Arrays.toString(arr));
    }
}
