package week09.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * [연습 문제 5] 카테고리별 최저가 찾기
 * 문제: 상품 객체 리스트에서 "전자기기" 카테고리의 상품 중
 * 가장 가격이 저렴한 상품의 이름을 구하세요.
 * (단, 이름(String), 가격(int), 카테고리(String)를 필드로 갖는 Product 클래스를 직접 생성하여 사용하세요.)
 */
public class Problem5 {
    public static void main(String[] args)
    {
        // TODO
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product("전자기기","컴퓨터",150000),
                new Product("전자기기","키보드",120000),
                new Product("전자기기","마우스",110000),
                new Product("문구","볼펜",2000)
        ));

        String minName = products.stream().filter(p->p.getCategory().equals("전자기기")).min(Comparator.comparingInt(Product::getPrice)).map(Product::getName).orElse("없음");
        System.out.println("가장싼 전자기기: "+minName);
    }

    static class Product
    {
        String name;
        int price;
        String category;

        Product(String category, String name, int price)
        {
            this.name = name;
            this.price = price;
            this.category=category;
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

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }
    }

}
