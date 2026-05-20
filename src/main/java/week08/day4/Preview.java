package week08.day4;

import java.util.HashSet;

/**
 * [예습 파일] Week 08 Day 4 — HashSet 기초 (중복 제거 집합)
 * 
 * Set(집합)은 수학의 집합 개념과 비슷합니다.
 * 그 중 HashSet은 가장 널리 쓰이는 Set 구현체입니다.
 * 
 * [HashSet의 특징]
 * 1. 중복 불허: 똑같은 데이터를 두 번 넣으려고 해도 하나만 남습니다.
 * 2. 순서 없음: 데이터를 넣은 순서가 유지되지 않습니다. (넣은 대로 나오지 않음)
 * 3. 인덱스 없음: .get(0) 처럼 번호로 꺼내올 수 없습니다.
 * 
 * [언제 사용할까요?]
 * - 당첨자 명단에서 중복을 제거할 때
 * - 방문한 적이 있는 페이지 주소를 관리할 때
 */
public class Preview {
    public static void main(String[] args) {
        // 문자열을 담는 집합 생성
        HashSet<String> set = new HashSet<>();
        
        set.add("Java");
        set.add("Python");
        set.add("C++");
        set.add("Java"); // "Java"를 또 추가해봅니다.

        // 중복된 "Java"는 무시되어 사이즈는 3이 됩니다.
        System.out.println("집합에 담긴 데이터 개수: " + set.size());
        
        // 순서가 멋대로 출력되는 것을 확인해보세요.
        System.out.println("저장된 내용: " + set);

        // 특정 데이터가 있는지 확인할 때 매우 빠릅니다. (.contains)
        if (set.contains("Python")) {
            System.out.println("파이썬이 명단에 있습니다.");
        }
    }
}
