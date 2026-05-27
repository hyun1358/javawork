package week09.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [연습 문제 3] 필터 후 정렬 (sorted)
 * 문제: 점수 리스트 {50, 80, 90, 40, 100}에서 70점 이상인 사람만 골라 오름차순 정렬 후 출력하세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO
        List<Integer> nums = new ArrayList<>(Arrays.asList(50,80,90,40,100));
        nums.stream().sorted().filter(n -> n >= 70).forEach(n -> System.out.println(n));
    }
}
