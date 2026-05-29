package week09.day5;

import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class Answer5 {
    public static void main(String[] args) {
        // 3개의 제품 정보를 가지는 리스트 생성
        List<Product> list = Arrays.asList(
                new Product("마우스", 15000, "전자기기"),
                new Product("키보드", 35000, "전자기기"),
                new Product("볼펜", 1000, "문구")
        );
        
        String cheapestName = list.stream()
                // 카테고리가 "전자기기"인 제품만 필터링
                .filter(p -> p.cat.equals("전자기기"))
                // 가격을 기준으로 가장 저렴한 제품 찾기 (최솟값)
                .min(Comparator.comparingInt(p -> p.price))
                // 가장 저렴한 제품의 이름(name)을 추출
                .map(p -> p.name)
                // 만약 해당하는 전자기기가 없다면 "없음"을 반환
                .orElse("없음");
                
        // 결과 출력
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
