package week09.day3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Answer5 {
    public static void main(String[] args) {
        // 문자열 리스트 생성
        List<String> words = Arrays.asList("hi", "hello", "java", "a", "web");
        // 스트림을 생성하고, 문자열 길이가 3 이상인 단어만 필터링하여 새로운 리스트로 수집
        List<String> result = words.stream()
                .filter(w -> w.length() >= 3)
                .collect(Collectors.toList());
        // 결과 리스트 출력
        System.out.println(result);
    }
}
