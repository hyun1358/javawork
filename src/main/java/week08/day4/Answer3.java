package week08.day4;

import java.util.*;

/**
 * LinkedHashMap을 사용하여 데이터가 삽입된 순서대로 순회할 수 있음을 보여주는 예제입니다.
 */
public class Answer3 {
    public static void main(String[] args) {
        // LinkedHashMap은 입력된 키-값 쌍의 순서를 내부에 유지합니다.
        Map<String, String> map = new LinkedHashMap<>();
        map.put("B", "2");
        map.put("C", "3");
        map.put("A", "1");
        // 입력 순서가 유지되므로 "B, C, A" 순서로 출력됩니다.
        System.out.println("삽입 순서 유지: " + map); // B, C, A 순서
    }
}
