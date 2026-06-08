package week09.day5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * [학습 예제 4] Week 09 Day 5 — for문과 스트림 비교, flatMap 및 객체 최솟값 검색
 * 
 * [학습 핵심 이론: 루프의 스트림 전환 및 고성능 변환 API]
 * 2. 객체 리스트에서의 최솟값/최댓값 검색 및 Optional 연쇄:
 *    - 객체 리스트에서 `min()` 혹은 `max()`를 호출하여 특정 기준 필드값에 맞는 최적의 객체를 찾을 수 있습니다.
 *    - `min(Comparator.comparingInt(객체::get기준필드))`를 수행하면 최적 객체를 품은 `Optional<T>`가 반환됩니다.
 *    - 이 최적 객체로부터 특정 정보(예: 이름)만 추출하려면, Optional 내부에 `.map(객체::get이름)`을 연쇄 호출하고 최종적으로 `.orElse("기본값")`을 붙여 안전하게 마무리합니다.
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("\n=== Lab3: 객체 리스트에서 Comparator 최솟값 검색 및 필드 매핑 ===");
        List<ProductInfo> products = Arrays.asList(
                new ProductInfo("마우스", 15000, "전자기기"),
                new ProductInfo("키보드", 35000, "전자기기"),
                new ProductInfo("볼펜", 1000, "문구")
        );

        // "전자기기" 중 가장 저렴한 상품의 이름을 찾아내기
        // [필터] 전자기기만 -> [최솟값] 가격 기준 -> [매핑] 상품명 추출 -> [안전대책] 없으면 "없음"
        String cheapestElectricName = products.stream()
                .filter(p -> p.category.equals("전자기기"))
                .min(Comparator.comparingInt(p -> p.price)) // Optional<ProductInfo> 반환
                .map(p -> p.name)                            // Optional<String>으로 변환
                .orElse("없음");                             // 비어있을 시 "없음" 반환

        System.out.println("가장 저렴한 전자기기 상품명: " + cheapestElectricName); // 마우스
    }

    // Lab3용 상품 보조 클래스
    static class ProductInfo {
        String name;
        int price;
        String category;

        ProductInfo(String name, int price, String category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }
    }
}
