package week08.day2;

import java.util.HashMap;

/**
 * [연습 문제 5] 없는 키의 처리
 * 문제: HashMap에 없는 키를 get()으로 조회해보고, null일 때 "데이터 없음"을 출력하게 하세요.
 * 힌트: getOrDefault() 를 써도 좋습니다.
 */
public class Problem5 {
    public static void main(String[] args)
    {
        // TODO
        HashMap<String,Integer> test = new HashMap<>();
        test.put("홍길동",1253);
        test.put("일길동",1263);
        test.put("이길동",1236);
        test.put("삼길동",123243);

        if(test.get("이훈이") == null)
        {
            System.out.println("데이터 없음");
        }

        test.put("사길동",test.getOrDefault("사길동",0));

        System.out.println(test.get("사길동"));
    }
}
