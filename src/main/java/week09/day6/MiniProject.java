package week09.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * [미니 프로젝트] Week 09 Day 6 — 쇼핑몰 데이터 분석 (실습용)
 * <p>
 * 가이드(MiniProjectGuide.java)의 요구사항에 따라
 * 스트림을 활용한 데이터 분석 로직을 완성하세요!
 */
public class MiniProject {
    public static void main(String[] args) {
        // TODO: 상품 데이터 세팅 및 Stream 처리 로직 구현
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product(6, "도서", "소설책", 15000, 2.0),
                new Product(1, "전자기기", "노트북", 1500000, 5.0),
                new Product(9, "식품", "사과 1상자", 30000, 5.0),
                new Product(3, "전자기기", "게이밍 마우스", 50000, 3.0),
                new Product(11, "식품", "커피믹스", 15000, 3.0),
                new Product(4, "도서", "자바의 정석", 30000, 5.0),
                new Product(8, "의류", "티셔츠", 25000, 3.0),
                new Product(2, "전자기기", "스마트폰", 1000000, 4.0),
                new Product(7, "의류", "청바지", 60000, 4.0),
                new Product(10, "식품", "생수 24팩", 12000, 4.0),
                new Product(5, "도서", "스프링 부트 실전", 35000, 4.0)
        ));

        //특정상품만 출력
        products.stream().filter(p-> p.getCategory().equals("도서")).forEach(p-> System.out.println("카테고리:도서인 상품만 출력: "+p.getName()));
        System.out.println("====================================================================================================================================");
        //모든상품의 이름만 추출하여 가나다 순으로 정렬후 쉼표로 이어 출력
        String sort = products.stream().map(p->p.getName()).sorted().collect(Collectors.joining(", "));
        System.out.println(sort);
        System.out.println("====================================================================================================================================");
        //평점이4.0이상인 상품들의 평군 가격 구하기
        double avg = products.stream().filter(p->p.getRating() >= 4.0).mapToDouble(p->p.getPrice()).average().orElse(-1);
        System.out.println(avg+"원");
        System.out.println("====================================================================================================================================");
        //카테고리별로 상품 묶어서 보여주기
        Map<String,List<Product>> groupedProduct = products.stream().collect(Collectors.groupingBy(Product::getCategory));
        groupedProduct.forEach
                ((category, productsList) ->
                    {
                        System.out.println("["+category+"]");
                        productsList.forEach(product -> System.out.println(" - " + product.getName()));
                    });
    }

    static class Product {
        private int id;
        private String category;
        private String name;
        private int price;
        private double rating;

        Product(int id, String category, String name, int price, double rating) {
            this.id = id;
            this.category = category;
            this.name = name;
            this.price = price;
            this.rating = rating;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }
    }
}
