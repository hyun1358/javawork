package week08.day4;

import java.util.*;

/**
 * HashSet을 이용해 문자열 배열의 중복 데이터를 제거하고 그 결과를 확인하는 예제입니다.
 */
public class Answer1_1 {
    public static void main(String[] args) {
        String[] names = {"Kim", "Lee", "Kim", "Park", "Lee", "Choi"};
        
        // 1. HashSet을 생성하면서 바로 Arrays.asList()로 배열을 전달하여 중복 제거
        // 중복되는 "Kim", "Lee"는 한 번만 저장됩니다.
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(names));
        
        // 2. 결과 출력
        // Set은 요소들의 순서를 보장하지 않으므로 무작위 순서로 출력될 수 있습니다.
        System.out.println("고유 회원 목록: " + uniqueNames); // [Choi, Lee, Kim, Park] (순서 무관)
        System.out.println("고유 회원 수: " + uniqueNames.size() + "명"); // 4명
    }
}
