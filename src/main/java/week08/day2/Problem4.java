package week08.day2;

import java.util.HashMap;
import java.util.Map;

/**
 * [연습 문제 4] HashMap 전체 출력
 * 문제: entrySet()을 사용하여 맵에 담긴 모든 키와 값을 깔끔하게 출력하세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO
        HashMap<String,Integer> test = new HashMap<>();
        test.put("홍길동",1253);
        test.put("일길동",1263);
        test.put("이길동",1236);
        test.put("삼길동",123243);

        for(Map.Entry<String, Integer> entry : test.entrySet())
        {
            System.out.println(entry.getKey()+" "+ entry.getValue());
        }
    }
}
