package week08.day4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * [연습 문제 1] 중복 값 제거
 * 문제: 배열 {1, 2, 2, 3, 3, 4}를 HashSet에 넣어 중복을 제거하고 출력하세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO
        Set<Integer> set = new HashSet<>(Arrays.asList(1,2,2,3,3,4));

        for(Integer i : set)
        {
            System.out.print(i+" ");
        }
    }
}
