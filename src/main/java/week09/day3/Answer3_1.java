package week09.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Answer3_1 {
    public static void main(String[] args) {
        // 변경 가능한 정수형 리스트 생성
        List<Integer> scores = new ArrayList<>(Arrays.asList(65, 80, 55, 90, 75, 100));

        // 스트림을 생성하여 70점 이상인 점수만 필터링하고 오름차순으로 정렬한 뒤 출력
        scores.stream()
              .filter(score -> score >= 70)
              .sorted()
              .forEach(System.out::println);
    }
}
