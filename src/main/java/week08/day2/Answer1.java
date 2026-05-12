package week08.day2;

import java.util.HashMap;

public class Answer1 {
    public static void main(String[] args) {
        HashMap<String, String> book = new HashMap<>();
        book.put("홍길동", "010-1234-5678");
        System.out.println("홍길동 번호: " + book.get("홍길동"));
    }
}
