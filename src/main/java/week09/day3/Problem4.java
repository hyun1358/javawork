package week09.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [연습 문제 4] 중복 제거 및 제한 (distinct, limit)
 * 문제: 배열 {1, 2, 2, 3, 3, 3, 4, 5}를 스트림으로 만들어 중복을 제거한 뒤, 앞에서 3개만 출력하세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,2,3,3,3,4,5));

        nums.stream().distinct().limit(3).forEach(n-> System.out.println(n));
    }
}
