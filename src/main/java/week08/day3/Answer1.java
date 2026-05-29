package week08.day3;

import java.util.*;

/**
 * Collections.sort를 사용하여 리스트를 오름차순 및 내림차순으로 정렬하는 예제입니다.
 */
public class Answer1 {
    public static void main(String[] args) {
        // 정수들이 담긴 불변 리스트를 생성합니다. (단, Collections.sort는 원본 리스트를 변경하므로
        // Arrays.asList로 만든 리스트는 크기 변경은 안 되지만 요소 변경은 가능합니다)
        List<Integer> list = Arrays.asList(4, 1, 5, 2, 3);
        
        // 기본적으로 오름차순 정렬을 수행합니다.
        Collections.sort(list);
        System.out.println("오름차순: " + list);
        
        // Collections.reverseOrder()를 전달하여 내림차순으로 정렬합니다.
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("내림차순: " + list);
    }
}
