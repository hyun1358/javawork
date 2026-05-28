package week09.day4;

import java.util.Arrays;
import java.util.List;

public class Answer1_2 {
    public static void main(String[] args) {
        List<Integer> prices = Arrays.asList(15000, 25000, 40000, 12000);
        double averagePrice = prices.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("평균 가격: " + averagePrice);
    }
}
