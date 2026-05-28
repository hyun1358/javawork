package week09.day4;

import java.util.*;

/**
 * [연습 문제 1] 점수 평균 구하기
 * 문제: 점수 리스트의 평균을 mapToInt와 average()를 활용해 구하세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        double avg = nums.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println(avg);

        //Optional<Double>가 안되는이유 그냥 자동완성에 있어서 OptionalDouble씀
    }
}
