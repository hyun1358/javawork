package week09.day3;

import java.util.Arrays;
import java.util.List;

public class Answer1 {
    public static void main(String[] args) {
        // 정수형 리스트 생성
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        // 스트림을 생성하고, 짝수만 필터링한 후, 결과를 출력
        list.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
    }
}
