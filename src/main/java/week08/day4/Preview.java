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
 * - 로또 번호처럼 서로 겹치지 않는 무작위 수의 묶음을 만들 때 (.size() 이용)
 */
public class Preview {
    public static void main(String[] args) {
        System.out.println("=== Lab 1: HashSet의 기본 중복 제거 ===");
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

        System.out.println("\n=== Lab 2: 중복 없이 N개 모으기 응용 ===");
        // 예: 중복을 방지하면서 원하는 개수(예: 3개)만큼 무작위 숫자를 모으기
        HashSet<Integer> randomNumbers = new HashSet<>();
        
        // 자바에서 난수(랜덤 숫자) 생성하기:
        // Math.random()은 0.0 이상 1.0 미만의 소수를 반환합니다.
        // 여기에 10을 곱하고 1을 더한 후 형변환하면 1~10 사이의 정수가 됩니다.
        // 예: (int)(Math.random() * 10) + 1
        
        while (randomNumbers.size() < 3) {
            int num = (int) (Math.random() * 10) + 1; // 1~10 사이 난수
            randomNumbers.add(num); // 중복된 숫자는 어차피 무시되므로, Set의 크기는 진짜 겹치지 않는 숫자가 추가될 때만 늘어납니다!
        }
        
        System.out.println("중복 없는 무작위 숫자 3개: " + randomNumbers);
    }
}
