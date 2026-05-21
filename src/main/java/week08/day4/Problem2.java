package week08.day4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * [연습 문제 2] 차집합 구하기
 * 문제: s1(1,2,3)과 s2(3,4,5)에서 s1에만 있는 요소를 구하세요. (removeAll 활용)
 */
public class Problem2 {
    public static void main(String[] args)
    {
        // TODO
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(3,4,5));

        s1.removeAll(s2);

        System.out.println(s1);
    }
}
