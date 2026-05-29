package week09.day5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * [보충 문제] 고객별 총 결제 금액 구하기 (GroupingBy 활용)
 * 
 * 문제:
 * 쇼핑몰의 주문 내역 리스트가 주어집니다. 각 주문(Order)에는 고객 이름과 결제 금액이 들어있습니다.
 * Stream API의 `Collectors.groupingBy`와 `Collectors.summingInt`를 사용하여,
 * 각 고객(이름)별로 총 결제한 금액을 Map<String, Integer> 형태로 구하고 출력하세요.
 */
public class BonusProblem {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("김철수", 15000),
            new Order("이영희", 20000),
            new Order("김철수", 5000),
            new Order("박지성", 30000),
            new Order("이영희", 15000)
        );

        // TODO: 아래에 스트림을 사용하여 각 고객별 총 결제 금액을 구하는 코드를 작성하세요.
        Map<String, Integer> totalAmountByUser = orders.stream().collect(Collectors.groupingBy(Order::getCustomerName,Collectors.summingInt(Order::getAmount)));
        System.out.println(totalAmountByUser);
        
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
