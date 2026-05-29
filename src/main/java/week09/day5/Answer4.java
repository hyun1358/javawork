package week09.day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Answer4 {
    public static void main(String[] args) {
        // 과일 이름을 요소로 가지는 리스트 생성
        List<String> fruits = Arrays.asList("사과", "바나나", "포도");
        
        // 스트림의 요소들을 쉼표(,)로 구분하고 앞에 "과일 목록: "을 붙여서 하나의 문자열로 결합
        String result = fruits.stream().collect(Collectors.joining(", ", "과일 목록: ", ""));
        
        // 결과 출력
        System.out.println(result);
    }
}
