package week09.day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Answer3 {
    public static void main(String[] args) {
        // 두 개의 문자열을 가지는 리스트 생성
        List<String> list = Arrays.asList("Hello World", "Java Stream");
        
        List<String> words = list.stream()
                // 각 문자열을 공백을 기준으로 분리하여 배열로 매핑
                .map(s -> s.split(" "))
                // 여러 개의 문자열 배열을 하나의 스트림으로 평탄화(병합)
                .flatMap(Arrays::stream)
                // 분리된 모든 단어들을 새로운 리스트로 수집
                .collect(Collectors.toList());
                
        // 결과 출력
        System.out.println(words);
    }
}
