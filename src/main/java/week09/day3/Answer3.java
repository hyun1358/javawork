package week09.day3;

import java.util.Arrays;
import java.util.List;

public class Answer3 {
    public static void main(String[] args) {
        // 정수형 리스트 생성
        List<Integer> list = Arrays.asList(50, 80, 90, 40, 100);
        // 스트림을 생성하고, 70 이상의 점수만 필터링한 후, 오름차순으로 정렬하여 출력
        list.stream().filter(s -> s >= 70).sorted().forEach(System.out::println);
    }
}
