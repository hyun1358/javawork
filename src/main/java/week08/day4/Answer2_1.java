package week08.day4;

import java.util.*;

/**
 * Set의 retainAll 메서드를 사용하여 두 집합 간의 교집합을 구하는 예제입니다.
 */
public class Answer2_1 {
    public static void main(String[] args) {
        Set<String> soccer = new HashSet<>(Arrays.asList("Kim", "Lee", "Park"));
        Set<String> basketball = new HashSet<>(Arrays.asList("Lee", "Choi", "Kim"));
        
        // soccer 집합을 기준으로 basketball과의 교집합(retainAll)을 구합니다.
        // soccer 집합 내부 요소 중 basketball에 없는 요소는 삭제됩니다.
        soccer.retainAll(basketball);
        
        System.out.println("공통 가입 회원(교집합): " + soccer); // [Lee, Kim] (순서 무관)
    }
}
