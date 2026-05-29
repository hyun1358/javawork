package week03.day2;

import java.util.Arrays;

public class Answer3 {
    // 메인 메서드: 두 배열을 하나로 병합하는 로직 실행
    public static void main(String[] args) {
        // 첫 번째 배열 초기화
        int[] arr1 = {1, 2, 3};
        // 두 번째 배열 초기화
        int[] arr2 = {4, 5, 6};
        // 두 배열의 길이를 합친 크기의 새로운 결과 배열 생성
        int[] result = new int[arr1.length + arr2.length];

        // arr1의 데이터를 result 배열의 시작(0)부터 복사
        System.arraycopy(arr1, 0, result, 0, arr1.length);
        // arr2의 데이터를 result 배열 내 arr1이 끝난 지점부터 복사
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);

        // 병합된 결과 배열 출력
        System.out.println(Arrays.toString(result));
    }
}
