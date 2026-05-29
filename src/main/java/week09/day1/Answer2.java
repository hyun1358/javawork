package week09.day1;

import java.util.*;

// 문자열 리스트를 특정 기준에 따라 정렬하는 예제 클래스입니다.
public class Answer2 {
    public static void main(String[] args) {
        // Arrays.asList를 사용하여 고정 크기의 문자열 리스트를 생성합니다.
        List<String> list = Arrays.asList("Banana", "Apple", "Kiwi");
        
        // 람다식을 사용하여 리스트를 정렬합니다.
        // 두 문자열의 길이를 비교하여 오름차순(짧은 문자열부터) 정렬을 수행합니다.
        // s1.length() - s2.length()의 결과가 양수면 s1이 길고, 음수면 s2가 깁니다.
        list.sort((s1, s2) -> s1.length() - s2.length());
        
        // 정렬이 완료된 리스트를 출력합니다.
        System.out.println(list);
    }
}
