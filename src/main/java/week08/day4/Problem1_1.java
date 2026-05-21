package week08.day4;

import java.util.*;

/**
 * [연습 문제 1-1] 고유한 이름 개수 세기 및 중복 제거
 * 문제: 중복된 이름들이 들어있는 문자열 배열 {"Kim", "Lee", "Kim", "Park", "Lee", "Choi"} 가 있습니다.
 *      이 배열에서 중복을 제거한 고유한 이름들을 추출하고, 총 몇 명의 고유한 회원(이름)이 존재하는지 출력해 보세요.
 */
public class Problem1_1 {
    public static void main(String[] args)
    {
        // TODO
        Set<String> names = new HashSet<>(Arrays.asList("Kim", "Lee", "Kim", "Park", "Lee", "Choi"));

        System.out.println("회원: "+names.size());
        for(String name : names)
        {
            System.out.println(name);
        }

    }
}
