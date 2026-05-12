package week03.day2;

import java.util.Arrays;

/*
 * [정답 + 해설 1] Week 03 Day 2
 * 문제: 임의 숫자 배열 오름차순 정렬
 */
public class Answer1 {
    public static void main(String[] args) {
        int[] arr = {34, 12, 89, 5, 21};

        // 1. 오름차순 정렬
        Arrays.sort(arr);

        // 2. 결과 출력
        System.out.println("정렬 결과: " + Arrays.toString(arr));
    }
}
/*
 * [해설]
 * - Arrays.sort()는 가장 기본적인 오름차순 정렬 기능을 제공합니다.
 * - 출력할 때 Arrays.toString()을 사용하면 배열 내용을 한눈에 볼 수 있습니다.
 */
