package week08.day1;

import java.util.ArrayList;

/**
 * ArrayList의 기본적인 생성, 데이터 추가, 삭제를 다루는 예제입니다.
 */
public class Answer1 {
    public static void main(String[] args) {
        // String 타입의 객체를 저장하는 동적 배열 ArrayList를 생성합니다.
        ArrayList<String> names = new ArrayList<>();
        // add 메서드를 사용하여 리스트에 요소를 추가합니다.
        names.add("홍길동");
        names.add("이순신");
        names.add("유관순");
        
        // remove 메서드를 사용하여 리스트에서 지정된 요소를 삭제합니다.
        names.remove("이순신");
        
        // 남아있는 요소들을 출력합니다.
        for (String n : names) System.out.println(n);
    }
}
