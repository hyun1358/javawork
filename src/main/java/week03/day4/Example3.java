package week03.day4;

/**
 * [학습 예제 3] Week 03 Day 4 — 객체 참조와 병렬 배열
 * 
 * [학습 핵심 이론: 참조 타입 배열 및 병렬 배열 데이터 구조]
 * 2. 문자열 내용 비교 (`.equals()`):
 *    - 참조형 변수나 배열 요소의 값을 비교할 때는 `==`(주소 비교) 대신 반드시 `.equals()` 메서드를 사용해 내용 자체를 비교해야 합니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: 문자열 배열에서 특정 문자열 검색 (.equals() 활용) (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab3: 문자열 배열에서 특정 문자열 검색 (.equals() 활용) (Problem 3 연계) ---");
        Lab3.run();
    }

    static class Lab3 {
        static void run() {
            // Problem 3: equals()를 활용한 문자열 탐색 및 인덱스 출력
            String[] names = {"Kim", "Lee", "Park", "Choi"};
            String target = "Park";
            int index = -1; // 찾지 못한 경우를 기본값으로 설정

            for (int i = 0; i < names.length; i++) {
                // 중요: 문자열 비교 시 절대 == 를 쓰지 않고 .equals()를 사용합니다.
                if (names[i].equals(target)) {
                    index = i;
                    break; // 찾았으므로 즉시 중단
                }
            }

            if (index != -1) {
                System.out.printf("문자열 \"%s\"은(는) 배열의 %d번째 인덱스에 존재합니다.\n", target, index);
            } else {
                System.out.printf("문자열 \"%s\"은(는) 배열에 없습니다.\n", target);
            }
        }
    }
}
