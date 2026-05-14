package week08.day1;

import java.util.ArrayList;

/**
 * [예습 파일] Week 08 Day 1 — ArrayList 기초
 * 
 * [새로운 개념: ArrayList]
 * 지금까지 썼던 '배열'은 크기가 고정되어 불편했습니다.
 * ArrayList는 데이터를 넣는 만큼 크기가 "자동으로 늘어나는" 마법 같은 배열입니다.
 * 
 * [배열 vs ArrayList]
 * 1. 크기: 고정됨 vs 자동으로 늘어남
 * 2. 추가: 직접 인덱스 관리 vs .add() 메서드 사용
 * 3. 개수 확인: .length vs .size()
 * 
 * [제네릭 < > ]
 * <String>은 이 리스트에 "문자열"만 담겠다는 약속입니다. (데이터 타입 고정)
 */
public class Preview {
    public static void main(String[] args) {
        // ArrayList<String> : 문자열 전용 리스트 생성
        ArrayList<String> list = new ArrayList<>();
        
        // 데이터 추가가 아주 쉽습니다! (.add)
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // .length 대신 .size()를 사용합니다.
        System.out.println("총 개수: " + list.size());
        
        // [인덱스]로 꺼내올 때는 .get(번호)를 사용합니다.
        System.out.println("0번째: " + list.get(0));

        // 데이터 삭제도 메서드 하나로 끝납니다. (.remove)
        list.remove("Banana");
        System.out.println("삭제 후: " + list);
    }
}
