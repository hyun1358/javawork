package week09.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [연습 문제 1] for문 리팩토링
 * 문제: 리스트 {1, 2, 3, 4, 5}에서 홀수만 찾아서 각각 2배로 만든 뒤 출력하는 코드를 스트림으로 구현하세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        nums.stream().filter(n-> n % 2 != 0).map(n-> n * 2).forEach(n-> System.out.print(n+" "));
    }
}
