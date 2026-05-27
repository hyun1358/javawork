package week09.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [추가 보충 문제 3-1] 스트림 필터링과 정렬 심화
 * 문제: 점수 리스트 {65, 80, 55, 90, 75, 100}에서 70점 이상인 점수만 필터링하여 오름차순으로 정렬한 뒤 출력하세요.
 * 
 * 필수 조건:
 * - 스트림의 filter()와 sorted()를 모두 적용해야 합니다.
 * - 최종 출력은 각 라인에 하나씩 출력되도록 하세요.
 */
public class Problem3_1 {
    public static void main(String[] args) {
        // TODO: 아래 리스트를 스트림으로 변환하여 문제를 해결해보세요!
        List<Integer> scores = new ArrayList<>(Arrays.asList(65, 80, 55, 90, 75, 100));
        scores.stream().filter(n-> n >= 70).sorted().forEach(System.out::println);
        
    }
}
