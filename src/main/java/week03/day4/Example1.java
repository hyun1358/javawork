package week03.day4;

/**
 * [학습 예제 1] Week 03 Day 4 — 객체 참조와 병렬 배열
 * 
 * [학습 핵심 이론: 참조 타입 배열 및 병렬 배열 데이터 구조]
 * 1. String 배열의 특징:
 *    - String은 참조 타입이므로, String[] 배열 내부의 각 방은 실제 문자열 객체의 주소값을 저장합니다.
 *    - 문자열을 정렬할 때는 `Arrays.sort()`를 사용하며, 알파벳 사전 순으로 정렬됩니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: 문자열 배열 정렬 (Problem 1 연계)
 */
import java.util.Arrays;

public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: 문자열 배열 정렬 (Problem 1 연계) ---");
        Lab1.run();
    }

    static class Lab1 {
        static void run() {
            // Problem 1: 5가지 과일 이름 배열 선언 및 알파벳순 정렬
            String[] fruits = {"Pineapple", "Apple", "Orange", "Banana", "Cherry"};
            System.out.println("정렬 전: " + Arrays.toString(fruits));
            
            Arrays.sort(fruits);
            System.out.println("정렬 후: " + Arrays.toString(fruits));
        }
    }
}
