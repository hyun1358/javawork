package week08.day2;

import java.util.HashMap;

/**
 * [예습 파일] Week 08 Day 2 — HashMap 기초
 * 
 * [핵심 개념: Key-Value 쌍으로 데이터를 다루는 해시맵]
 * 1. Map 인터페이스의 특징:
 *    - 순서(인덱스)로 데이터를 관리하는 리스트 구조와 달리, 고유한 키(Key)와 그에 일치하는 값(Value)의 쌍으로 데이터를 결합해 보관합니다.
 *    - 키(Key)는 절대 중복될 수 없으며, 값(Value)은 얼마든지 중복을 허용합니다.
 * 
 * 2. 해싱(Hashing) 알고리즘을 통한 초고속 검색:
 *    - HashMap은 내부적으로 키(Key) 값을 수학적 해시 함수에 통과시켜 주소 고유 값을 계산해 냅니다.
 *    - 인덱스 루프를 돌 필요 없이 키값을 호출하면 다이렉트 주소 매핑이 발생하여 데이터 크기에 상관없이 상수 시간 복잡도 O(1)의 경이적인 속도로 검색 결과를 추출합니다.
 */
public class Preview {
    public static void main(String[] args) {
        // 키-값 형태의 자료구조
        HashMap<String, Integer> map = new HashMap<>();
        map.put("사과", 1000);
        map.put("바나나", 1500);

        System.out.println("사과 가격: " + map.get("사과"));
        System.out.println("포도 가격: " + map.get("포도")); // 없으면 null 반환

        map.put("사과", 1200); // 덮어쓰기
        System.out.println("변경된 사과: " + map.get("사과"));
    }
}
