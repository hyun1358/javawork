package week08.day4;

import java.util.*;

/**
 * Set의 removeAll 메서드를 사용하여 차집합을 구하는 예제입니다.
 */
public class Answer2 {
    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(3, 4, 5));
        // s1에서 s2에 포함된 요소들을 모두 제거합니다. 결과적으로 s1에는 차집합 요소만 남습니다.
        s1.removeAll(s2);
        System.out.println("차집합: " + s1);
    }
}
