package week07.day5;

/**
 * [학습 예제 4] Week 07 Day 5 — String 클래스와 효율적 가공
 * 
 * [학습 핵심 이론: 실무형 문자열 제어와 성능 최적화]
 * 2. StringBuilder의 가치:
 *    - 내부 가변 문자배열 버퍼를 제공하므로, 루프 내부의 동적 결합 시 메모리 낭비 없이 고속으로 글자를 조립할 수 있습니다.
 * 
 * [문제별 학습 목표]
 * - Lab4: 문자열 반복 연산 시 String vs StringBuilder 성능 비교 (Problem 4 연계)
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab4: 문자열 반복 연산 시 String vs StringBuilder 성능 비교 (Problem 4 연계) ---");
        Lab4.run();
    }

    static class Lab4 {
        static void run() {
            // Problem 4: StringBuilder 활용법 및 성능 강점 설명
            String piece = "a";
            
            // 1. StringBuilder를 이용한 효율적인 조립
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                sb.append(piece); // 객체 재성성 없이 가변 버퍼에 추가
            }
            String result = sb.toString();
            System.out.println("StringBuilder 10회 조립 결과: " + result);

            System.out.println("[이론 가이드] 반복문 내 문자열 연산 시, 일반 String 더하기(+=)는 힙에 10개의 가비지 객체를 만듭니다.");
            System.out.println("반면, StringBuilder는 단 하나의 내부 버퍼만 유지하여 수천 배 이상 빠르고 가볍게 처리됩니다.");
        }
    }
}
