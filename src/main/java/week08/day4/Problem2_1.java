package week08.day4;

import java.util.*;

/**
 * [연습 문제 2-1] 동아리 공통 가입 회원 찾기 (교집합)
 * 문제: 축구 동아리 회원 목록 soccer{"Kim", "Lee", "Park"}와
 *      농구 동아리 회원 목록 basketball{"Lee", "Choi", "Kim"}이 있습니다.
 *      두 동아리에 모두 가입한 공통 회원의 이름을 구해보세요. (힌트: Set의 retainAll 활용)
 */
public class Problem2_1 {
    public static void main(String[] args)
    {
        // TODO
        Set<String> soccer = new HashSet<>(Arrays.asList("Kim","Lee","Park"));
        Set<String> basketball = new HashSet<>(Arrays.asList("Lee","Choi","Kim"));

        soccer.retainAll(basketball);

        System.out.println(soccer);
    }
}
