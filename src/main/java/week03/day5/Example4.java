package week03.day5;

/**
 * [학습 예제 4] Week 03 Day 5 — Math API와 난수 생성
 * 
 * [학습 핵심 이론: Math 클래스와 난수(Random) 활용]
 * 4. 배열 기반 랜덤 선택:
 *    - 난수로 유효한 인덱스 범위 `(0 <= index < array.length)`를 추출하여 배열의 요소를 임의로 획득합니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: 문자열 배열에서 무작위 단어 선택 (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab4: 문자열 배열에서 무작위 단어 선택 (Problem 4 연계) ---");
        Lab4.run();
    }

    static class Lab4 {
        static void run() {
            // Problem 4: 무작위 단어 선택
            String[] words = {"Apple", "Book", "Car", "Java", "Python"};
            
            // 0 ~ (words.length - 1) 사이의 난수 인덱스
            int randIndex = (int) (Math.random() * words.length);
            String selected = words[randIndex];

            System.out.println("무작위로 선정된 오늘의 단어: " + selected);
        }
    }
}
