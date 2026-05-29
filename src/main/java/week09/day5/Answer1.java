package week09.day5;

import java.util.Arrays;
import java.util.List;

public class Answer1 {
    public static void main(String[] args) {
        // 1부터 5까지의 정수를 요소로 가지는 리스트 생성
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        
        list.stream()
                // 홀수만 필터링 (2로 나눈 나머지가 0이 아닌 요소)
                .filter(n -> n % 2 != 0)
                // 필터링된 각 요소에 2를 곱하여 매핑
                .map(n -> n * 2)
                // 최종적으로 각 요소를 출력
                .forEach(System.out::println);
    }
}
