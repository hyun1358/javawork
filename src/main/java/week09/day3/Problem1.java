package week09.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [연습 문제 1] 스트림 필터링
 * 문제: 숫자 리스트 {1, 2, 3, 4, 5, 6}에서 짝수만 골라내어 출력하세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

        nums.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
    }
}
