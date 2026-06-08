package week07.day6;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * [종합 미니 프로젝트 정답 - 신규] Week 07 Day 6
 * 「 람다와 스트림 기반의 주문 데이터 분석 시스템 」
 */
public class MiniProjectAnswer_New {
    public static void main(String[] args) {
        // 테스트 주문 데이터 생성
        List<Order> orders = Arrays.asList(
            new Order("ORD001", "홍길동", "Electronics", 1200000),
            new Order("ORD002", "이순신", "Books", 15000),
            new Order("ORD003", "강감찬", "Electronics", 850000),
            new Order("ORD004", "유관순", "Clothing", 45000),
            new Order("ORD005", "신사임당", "Books", 23000),
            new Order("ORD006", "을지문덕", "Clothing", 120000),
            new Order("ORD007", "홍범도", "Electronics", 200000)
        );

        // Day 1 & Day 2: 람다식 및 표준 함수형 인터페이스 사용
        // Electronics 카테고리 필터용 Predicate
        Predicate<Order> isElectronics = order -> order.getCategory().equalsIgnoreCase("Electronics");

        // Day 3: 스트림 기초 (filter, map, collect)
        // [미션 1] 전자제품("Electronics") 카테고리의 모든 주문을 필터링하여 출력
        System.out.println("=== 1. 전자제품 카테고리 주문 내역 ===");
        List<Order> electronicsOrders = orders.stream()
                .filter(isElectronics)
                .collect(Collectors.toList());
        
        // Day 5: 메서드 참조 (System.out::println)
        electronicsOrders.forEach(System.out::println);

        // Day 4: 스트림 심화 (mapToDouble, sum, reduce)
        // [미션 2] 전체 주문의 총 결제 금액 계산
        System.out.println("\n=== 2. 전체 주문 총 결제 금액 ===");
        double totalSales = orders.stream()
                .mapToDouble(Order::getPrice) // Day 5: 메서드 참조
                .sum();
        System.out.printf("총 매출액: %,.0f원\n", totalSales);

        // [미션 3] 주문 금액 기준 내림차순 정렬하여 상위 3개의 주문 추출
        System.out.println("\n=== 3. 고액 주문 Top 3 ===");
        orders.stream()
                .sorted(Comparator.comparingDouble(Order::getPrice).reversed()) // Day 4: 정렬
                .limit(3)
                .forEach(System.out::println);

        // [미션 4] 카테고리별로 주문 목록 그룹핑하여 출력
        System.out.println("\n=== 4. 카테고리별 그룹핑 ===");
        Map<String, List<Order>> groupedOrders = orders.stream()
                .collect(Collectors.groupingBy(Order::getCategory)); // Day 4: groupingBy
        
        groupedOrders.forEach((category, list) -> {
            System.out.println("[" + category + "]");
            list.forEach(order -> System.out.println("   - " + order.getCustomerName() + ": " + order.getPrice() + "원"));
        });

        // Day 5: Optional 사용 및 메서드 참조
        // [미션 5] 가장 높은 주문 금액을 가진 주문을 찾아 출력
        System.out.println("\n=== 5. 최고 금액 단일 주문 ===");
        Optional<Order> maxOrder = orders.stream()
                .max(Comparator.comparingDouble(Order::getPrice)); // Optional 반환

        // Optional 안전하게 다루기
        Order defaultOrder = new Order("ORD000", "없음", "없음", 0);
        Order topOrder = maxOrder.orElse(defaultOrder); 
        
        if (topOrder.getPrice() > 0) {
            System.out.println("최고가 주문: " + topOrder);
        } else {
            System.out.println("주문 내역이 없습니다.");
        }
    }
}

// 주문 정보를 나타내는 클래스
class Order {
    private String orderId;
    private String customerName;
    private String category;
    private double price;

    public Order(String orderId, String customerName, String category, double price) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.category = category;
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("[%s] 고객: %s | 카테고리: %-12s | 금액: %,.0f원", 
                orderId, customerName, category, price);
    }
}
