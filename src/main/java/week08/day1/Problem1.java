package week08.day1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * [연습 문제 1] 이름 리스트 관리
 * 문제: 이름을 저장하는 ArrayList를 만들고 3명을 추가, 1명 삭제, 모두 출력하세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO
        ArrayList<String> names = new ArrayList<>(Arrays.asList("홍길동","김철수","이유리"));
        names.remove(0);
        for(String name : names)
        {
            System.out.println(name);
        }
    }
}
