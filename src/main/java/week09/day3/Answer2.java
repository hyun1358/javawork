package week09.day3;

import java.util.Arrays;
import java.util.List;

public class Answer2 {
    public static void main(String[] args) {
        // 문자열 리스트 생성
        List<String> list = Arrays.asList("kim", "lee", "park");
        // 스트림을 생성하고, 모든 문자열을 대문자로 변환한 후, 결과를 출력
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
