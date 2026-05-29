package week09.day5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * [보충 문제 정답] 고객별 총 결제 금액 구하기 (GroupingBy 활용)
 */
public class BonusAnswer {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("김철수", 15000),
            new Order("이영희", 20000),
            new Order("김철수", 5000),
            new Order("박지성", 30000),
            new Order("이영희", 15000)
        );

        // 정답 코드
        Map<String, Integer> totalAmountByUser = orders.stream()
            .collect(Collectors.groupingBy(
                Order::getCustomerName,
                Collectors.summingInt(Order::getAmount)
            ));

        System.out.println("고객별 총 결제 금액: " + totalAmountByUser);
        // 예상 출력: 고객별 총 결제 금액: {김철수=20000, 박지성=30000, 이영희=35000}
    }

    static class Order {
        String customerName;
        int amount;

        Order(String customerName, int amount) {
            this.customerName = customerName;
            this.amount = amount;
        }

        public String getCustomerName() {
            return customerName;
        }

        public int getAmount() {
            return amount;
        }
    }
}
