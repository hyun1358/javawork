package week09.day4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Answer2 {
    public static void main(String[] args) {
        // 점수 리스트 생성
        List<Integer> list = Arrays.asList(50, 60, 40, 80, 90);
        
        // 60점 이상인지 여부에 따라 "합격"과 "불합격" 그룹으로 나눔
        // Collectors.groupingBy를 사용하여 조건에 맞는 맵 형태로 수집
        Map<String, List<Integer>> map = list.stream()
                .collect(Collectors.groupingBy(s -> s >= 60 ? "합격" : "불합격"));
                
        // 분류된 결과 맵 출력
        System.out.println(map);
    }
}
