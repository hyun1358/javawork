package week09.day4;

import java.util.Arrays;
import java.util.List;

public class Answer1_2 {
    public static void main(String[] args) {
        // 가격 정보를 담은 리스트 생성
        List<Integer> prices = Arrays.asList(15000, 25000, 40000, 12000);
        
        // 스트림을 통해 가격 데이터의 평균을 계산
        // mapToInt를 통해 int형 스트림으로 변환 후 average() 호출
        double averagePrice = prices.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
                
        // 평균 가격 출력
        System.out.println("평균 가격: " + averagePrice);
    }
}
