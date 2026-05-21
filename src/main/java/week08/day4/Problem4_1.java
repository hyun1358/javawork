package week08.day4;

import java.util.*;

/**
 * [연습 문제 4-1] 정렬된 로또 번호
 * 문제: 1~45 사이의 난수를 중복 없이 6개 추출하되, 
 *      출력할 때는 반드시 오름차순(작은 수부터 큰 수 순서)으로 정렬하여 출력하세요.
 * 
 * 힌트: 
 *   1. TreeSet을 사용하면 자동으로 중복이 제거되면서 오름차순 정렬까지 한 번에 해결됩니다.
 *   2. 또는, 기존의 HashSet으로 6개를 다 모은 뒤, List로 옮겨 닮아 Collections.sort()로 정렬할 수도 있습니다.
 */
public class Problem4_1 {
    public static void main(String[] args)
    {
        // TODO
        Set<Integer> lotto1 = new TreeSet<>();

        while (lotto1.size() < 6)
        {
            int random = (int)(Math.random() * 45) + 1;
            lotto1.add(random);
        }

        System.out.println("TreeSet사용 : "+lotto1);

        Set<Integer> lotto2 = new HashSet<>();
        while (lotto2.size() < 6)
        {
            int random = (int)(Math.random() * 45) + 1;
            lotto2.add(random);
        }

        List<Integer> list = new ArrayList<>(lotto2);
        Collections.sort(list);

        System.out.println(list);

    }
}
