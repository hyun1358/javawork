package week08.day2;

import java.util.HashMap;

/**
 * HashMap을 사용하여 키-값(Key-Value) 쌍으로 데이터를 저장하고 조회하는 기본 예제입니다.
 */
public class Answer1 {
    public static void main(String[] args) {
        // String 타입의 키와 값을 가지는 HashMap 객체를 생성합니다.
        HashMap<String, String> book = new HashMap<>();
        // put 메서드를 사용하여 전화번호부에 이름(키)과 번호(값)를 저장합니다.
        book.put("홍길동", "010-1234-5678");
        // get 메서드에 키("홍길동")를 전달하여 해당하는 값(전화번호)을 조회합니다.
        System.out.println("홍길동 번호: " + book.get("홍길동"));
    }
}
