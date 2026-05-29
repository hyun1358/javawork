package week08.day4;

import java.util.*;

/**
 * HashSet을 사용하여 배열의 중복을 제거하는 예제입니다.
 */
public class Answer1 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 2, 3, 3, 4};
        // Arrays.asList를 사용하여 배열을 리스트로 만들고, 이를 HashSet 생성자에 전달합니다.
        // Set 자료구조의 특성상 중복된 값은 무시되므로 고유한 값만 남게 됩니다.
        Set<Integer> set = new HashSet<>(Arrays.asList(arr));
        System.out.println("중복 제거: " + set);
    }
}
