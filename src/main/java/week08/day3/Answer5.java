package week08.day3;

import java.util.*;

/**
 * 리스트를 정렬한 후 상위 N개의 요소(Top N)를 추출하는 예제입니다.
 */
public class Answer5 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(50, 90, 80, 100, 60);
        // 점수가 가장 높은 요소부터 보기 위해 내림차순으로 정렬합니다.
        list.sort(Collections.reverseOrder());
        System.out.println("Top 3:");
        // 정렬된 리스트의 앞에서부터 3개의 요소만 출력하여 Top 3를 구합니다.
        for (int i = 0; i < 3; i++) System.out.println(list.get(i));
    }
}
