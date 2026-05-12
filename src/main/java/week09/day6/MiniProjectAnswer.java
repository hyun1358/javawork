package week09.day6;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MiniProjectAnswer {
    public static void main(String[] args) {
        List<Item> products = Arrays.asList(
                new Item(1, "게이밍 마우스", 50000, "전자", 4.5),
                new Item(2, "기계식 키보드", 120000, "전자", 4.8),
                new Item(3, "볼펜", 1500, "문구", 3.5),
                new Item(4, "노트", 3000, "문구", 4.1),
                new Item(5, "이어폰", 25000, "전자", 3.9)
        );

        System.out.println("=== 1. 전자 카테고리 상품 ===");
        products.stream()
                .filter(p -> p.category.equals("전자"))
                .forEach(p -> System.out.println(p.name));

        System.out.println("\n=== 2. 상품 이름 정렬 ===");
        String sortedNames = products.stream()
                .map(p -> p.name)
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(sortedNames);

        System.out.println("\n=== 3. 평점 4.0 이상 평균 가격 ===");
        double avg = products.stream()
                .filter(p -> p.rating >= 4.0)
                .mapToInt(p -> p.price)
                .average().orElse(0);
        System.out.println(avg + "원");

        System.out.println("\n=== 4. 카테고리별 그룹핑 ===");
        Map<String, List<Item>> grouped = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));

        grouped.forEach((cat, list) -> {
            System.out.println("[" + cat + "]");
            list.forEach(item -> System.out.println(" - " + item.name));
        });
    }
}

class Item {
    int id;
    String name;
    int price;
    String category;
    double rating;

    Item(int i, String n, int p, String c, double r) {
        id = i;
        name = n;
        price = p;
        category = c;
        rating = r;
    }
}
