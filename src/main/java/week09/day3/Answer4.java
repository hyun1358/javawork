package week09.day3;

import java.util.Arrays;

public class Answer4 {
    public static void main(String[] args) {
        // 정수 배열 생성 (중복된 값 포함)
        int[] arr = {1, 2, 2, 3, 3, 3, 4, 5};
        // 배열로 스트림을 생성하고, 중복을 제거한 후, 처음 3개의 요소만 출력
        Arrays.stream(arr).distinct().limit(3).forEach(System.out::println);
    }
}
