package week08.day1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * [학습 예제 2] Week 08 Day 1 — 자료구조 컬렉션 ArrayList 기초
 * 
 * [학습 핵심 이론: 동적 배열 자료구조 ArrayList]
 * 1. ArrayList의 특징:
 *    - 제네릭(`<T>`) 설계로 인해 int, double 같은 기본형은 담을 수 없으므로 래퍼 클래스인 `Integer`, `Double` 등을 지정해 오토박싱(Autoboxing)을 이용해 사용합니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: Integer 리스트의 합계 및 실수 평균 계산 (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab2: Integer 리스트의 합계 및 실수 평균 계산 (Problem 2 연계) ---");
        Lab2.run();
    }

    static class Lab2 {
        static void run() {
            // Problem 2: 점수 리스트 통계
            ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(88, 92, 79, 95, 80));
            int sum = 0;
            
            for (int i = 0; i < scores.size(); i++) {
                sum += scores.get(i); // 오토언박싱(Integer -> int) 자동 수행
            }
            double avg = (double) sum / scores.size();

            System.out.println("점수 목록: " + scores);
            System.out.printf("점수 합계: %d | 점수 평균: %.1f\n", sum, avg);
        }
    }
}
