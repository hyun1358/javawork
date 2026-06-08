package week08.day2;

import java.util.Arrays;

/**
 * [학습 예제 3] Week 08 Day 2 — String.split()
 * 
 * [보충 이론 학습 가이드]
 * - split: 해당 일차 연습 문제 해결에 필수적인 split 기술 활용법을 보충 예제로 추가 설명했습니다.
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("\n=== [보충 Lab] String.split()을 이용한 정규식 문자열 분할 ===");
        // split은 지정된 구분문자(정규식)를 쪼개어 String[] 배열로 파싱해 줍니다.
        String[] tokens = "사과,바나나,포도".split(",");
        System.out.println("분할된 토큰 배열: " + Arrays.toString(tokens));
    }
}
