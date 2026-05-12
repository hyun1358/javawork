package week09.day5;

import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class Answer5 {
    public static void main(String[] args) {
        List<Product> list = Arrays.asList(
                new Product("마우스", 15000, "전자기기"),
                new Product("키보드", 35000, "전자기기"),
                new Product("볼펜", 1000, "문구")
        );
        String cheapestName = list.stream()
                .filter(p -> p.cat.equals("전자기기"))
                .min(Comparator.comparingInt(p -> p.price))
                .map(p -> p.name).orElse("없음");
        System.out.println("가장 싼 전자기기: " + cheapestName);
    }
}

class Product {
    String name;
    int price;
    String cat;

    Product(String n, int p, String c) {
        name = n;
        price = p;
        cat = c;
    }
}
