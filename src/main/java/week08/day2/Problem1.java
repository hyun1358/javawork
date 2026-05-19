package week08.day2;

import java.util.HashMap;

/**
 * [연습 문제 1] 전화번호부
 * 문제: 이름(String)을 키로, 전화번호(String)를 값으로 저장하는 HashMap을 만들고 조회하세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO
        HashMap<String,String> phoneBook = new HashMap<>();
        phoneBook.put("홍길동","010-1234-5678");
        phoneBook.put("김철수","010-4655-7565");
        phoneBook.put("유리","010-3456-6534");

        System.out.println(phoneBook.get("홍길동"));
        System.out.println(phoneBook.get("김철수"));
        System.out.println(phoneBook.get("훈이"));
    }
}
