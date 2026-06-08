package week03.day4;

/**
 * [학습 예제 2] Week 03 Day 4 — 객체 참조와 병렬 배열
 * 
 * [학습 핵심 이론: 참조 타입 배열 및 병렬 배열 데이터 구조]
 * 3. 병렬 배열(Parallel Array):
 *    - 논리적으로 연관된 여러 속성 데이터를 동일한 크기의 여러 1차원 배열로 나누어, 인덱스 `i`를 매개체로 연결하는 실무 기본 매핑 기법입니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: 병렬 배열을 이용한 성적 출력 (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab2: 병렬 배열을 이용한 성적 출력 (Problem 2 연계) ---");
        Lab2.run();
    }

    static class Lab2 {
        static void run() {
            // Problem 2: 이름 배열과 점수 배열 매핑 출력
            String[] names = {"Kim", "Lee", "Park"};
            int[] scores = {80, 95, 70};

            for (int i = 0; i < names.length; i++) {
                System.out.printf("%s의 점수는 %d점입니다.\n", names[i], scores[i]);
            }
        }
    }
}
