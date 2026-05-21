package week08.day4;

import java.util.*;

public class Answer1_1 {
    public static void main(String[] args) {
        String[] names = {"Kim", "Lee", "Kim", "Park", "Lee", "Choi"};
        
        // 1. HashSet을 생성하면서 바로 Arrays.asList()로 배열을 전달하여 중복 제거
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(names));
        
        // 2. 결과 출력
        System.out.println("고유 회원 목록: " + uniqueNames); // [Choi, Lee, Kim, Park] (순서 무관)
        System.out.println("고유 회원 수: " + uniqueNames.size() + "명"); // 4명
    }
}
