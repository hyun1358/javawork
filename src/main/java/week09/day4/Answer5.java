package week09.day4;

import java.util.Arrays;

public class Answer5 {
    public static void main(String[] args) {
        // 정수 배열 생성
        int[] arr = {3, 7, 1, 9, 2};
        
        // 배열을 스트림으로 변환 후 최대값을 구함
        // 만약 배열이 비어있다면 -1을 기본값으로 반환
        int max = Arrays.stream(arr).max().orElse(-1);
        
        // 최대값 출력
        System.out.println("최대값: " + max);
    }
}
