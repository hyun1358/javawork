package week09.day4;

import java.util.Arrays;
import java.util.List;

/**
 * [보충 문제 1_2] 평균 가격 구하기
 * 문제: 상품 가격 리스트의 평균을 구하세요. 만약 값이 없다면 0.0을 반환하세요.
 */
public class Problem1_2 {
    public static void main(String[] args) {
        List<Integer> prices = Arrays.asList(15000, 25000, 40000, 12000);

        // TODO: 스트림을 활용해 평균을 계산하고 orElse를 사용하여 추출하세요.
        double averagePrice = prices.stream().mapToInt(Integer::intValue).average().orElse(0.0);

        System.out.println("평균 가격: " + averagePrice);
    }
}
