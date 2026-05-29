package week09.day4;

import java.util.Arrays;
import java.util.List;

public class Answer1 {
    public static void main(String[] args) {
        // 점수 리스트 생성
        List<Integer> scores = Arrays.asList(80, 90, 100);
        
        // 스트림을 사용하여 정수형으로 변환 후 평균 계산, 값이 없을 경우 0.0 반환
        double avg = scores.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
                
        // 계산된 평균 출력
        System.out.println("평균: " + avg);
    }
}
