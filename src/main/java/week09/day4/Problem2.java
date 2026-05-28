package week09.day4;

import java.util.*;
import java.util.stream.Collectors;

/**
 * [연습 문제 2] 그룹핑
 * 문제: 점수 리스트 {50, 60, 40, 80, 90}을 60점 이상 "합격", 미만 "불합격" 두 그룹으로 Map에 나누어 담아보세요.
 */
public class Problem2 {
    public static void main(String[] args) {
        // TODO (힌트: groupingBy 내부에서 조건에 따라 "합격"/"불합격" 문자열을 반환하도록 설정)
        List<Integer> nums = new ArrayList<>(Arrays.asList(50,60,40,80,90));

        Map<String,List<Integer>> map = nums.stream().collect(Collectors.groupingBy(n-> n >= 60 ? "합격" : "불합격"));
        System.out.println(map);

    }
}
