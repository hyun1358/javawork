package week09.day5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * [학습 예제] Week 09 Day 5 — for문과 스트림 비교, flatMap 및 객체 최솟값 검색
 * 
 * [학습 핵심 이론: 루프의 스트림 전환 및 고성능 변환 API]
 * 1. flatMap (평탄화 연산)과 배열 스트림 변환:
 *    - `flatMap`은 2차원적인 데이터나 중첩된 구조를 1차원 선형 스트림으로 일렬로 펼치는 기법입니다.
 *    - 문자열 문장을 단어 단위로 쪼갤 때, `.map(s -> s.split(" "))`를 수행하면 결과가 `Stream<String[]>`이 됩니다.
 *    - 이 배열들을 문자열 요소로 1차원 평탄화하기 위해 `.flatMap(Arrays::stream)`을 사용하면 개별 단어들이 한 줄로 이어지는 `Stream<String>`을 깔끔히 수확할 수 있습니다.
 * 
 * 2. 객체 리스트에서의 최솟값/최댓값 검색 및 Optional 연쇄:
 *    - 객체 리스트에서 `min()` 혹은 `max()`를 호출하여 특정 기준 필드값에 맞는 최적의 객체를 찾을 수 있습니다.
 *    - `min(Comparator.comparingInt(객체::get기준필드))`를 수행하면 최적 객체를 품은 `Optional<T>`가 반환됩니다.
 *    - 이 최적 객체로부터 특정 정보(예: 이름)만 추출하려면, Optional 내부에 `.map(객체::get이름)`을 연쇄 호출하고 최종적으로 `.orElse("기본값")`을 붙여 안전하게 마무리합니다.
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: for문을 스트림으로 리팩토링 ===");
        List<Integer> list = Arrays.asList(10, 20, 30);
        // 기존 for문
        for (int n : list) {
            if (n > 10) System.out.print(n + " ");
        }
        System.out.println();
        // 스트림으로 리팩토링 (홀수 찾아서 2배 만들기 등도 동일 메커니즘)
        list.stream().filter(n -> n > 10).forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("\n=== Lab2: flatMap (중첩 리스트 및 문자열 쪼개기 평탄화) ===");
        // 예시 A: 중첩 리스트 평탄화
        List<List<String>> nested = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C", "D")
        );
        System.out.println(nested);

        List<String> flat = nested.stream()
                .flatMap(List::stream) // 리스트 안의 리스트들을 하나로 펼침
                .collect(Collectors.toList());
        System.out.println("리스트 평탄화 결과: " + flat); // [A, B, C, D]

        // 예시 B: 공백 문자열 분할 및 배열 평탄화 (실전 필수 문법!)
        List<String> sentences = Arrays.asList("Hello World", "Java Stream");
        List<String> words = sentences.stream()
                .map(s -> s.split(" "))   // 각 문장을 String[]로 쪼갬 (Stream<String[]>)
                .flatMap(Arrays::stream)  // String[] 배열들을 단어 스트림으로 평탄화 (Stream<String>)
                .collect(Collectors.toList());
        System.out.println("단어 분리 평탄화 결과: " + words); // [Hello, World, Java, Stream]

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
}

// Lab3용 상품 보조 클래스
class ProductInfo {
    String name;
    int price;
    String category;

    ProductInfo(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
