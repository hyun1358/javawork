package week09.day4;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * [연습 문제 5] 최대값 (max)
 * 문제: 배열 {3, 7, 1, 9, 2}에서 스트림의 max() 메서드를 활용하여 최대값을 구하고 출력하세요.
 */
public class Problem5 {
    public static void main(String[] args)
    {
        // TODO
        int[] arr = {3,7,1,9,2};

        int max = Arrays.stream(arr).max().orElse(-1);
        System.out.println(max);

        //왜 Stream<T>를 안쓰고 OptionalInt를 쓰는가
    }
}
