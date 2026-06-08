package week07.day5;

import java.util.Arrays;

/**
 * [학습 예제 3] Week 07 Day 5 — String 클래스와 효율적 가공
 * 
 * [학습 핵심 이론: 실무형 문자열 제어와 성능 최적화]
 * 3. String.split()과 토큰화:
 *    - 특정 구분자(Delimiter)를 기준으로 삼아 문자열을 조각내어 `String[]` 배열로 획득합니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: split("/")을 이용한 슬래시 구분 데이터 토큰화 (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab3: split(\"/\")을 이용한 슬래시 구분 데이터 토큰화 (Problem 3 연계) ---");
        Lab3.run();
    }

    static class Lab3 {
        static void run() {
            // Problem 3: "홍길동/20/남" split 분리
            String data = "홍길동/20/남";
            String[] tokens = data.split("/");
            System.out.println("원시 문자열: " + data);
            System.out.println("split 분리 결과 배열: " + Arrays.toString(tokens));
            
            // 일괄 출력
            for (int i = 0; i < tokens.length; i++) {
                System.out.printf("토큰[%d]: %s\n", i, tokens[i]);
            }
        }
    }
}
