package week05.day5;

/**
 * [학습 예제 1] Week 05 Day 5 — final 키워드와 불변 설계
 * 
 * [학습 핵심 이론: final 제약 조건을 활용한 안전성 극대화]
 * 2. static final (클래스 상수):
 *    - 클래스 차원에서 하나만 존재하고 절대 바뀌지 않는 공유 데이터입니다. 대문자와 언더바(`_`) 스네이크 케이스로 명명합니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: static final 상수를 활용한 원의 넓이 계산 (Problem 1 연계)
 */
public class Example1 {
    public static final double PI = 3.141592653589793;

    public static void main(String[] args) {
        int radius = 5;
        double area = radius * radius * PI; // static final PI 활용
        System.out.printf("반지름 %d인 원의 넓이: %.2f\n", radius, area);
    }
}
