package week08.day1;

import java.util.ArrayList;

/**
 * [학습 예제 1] Week 08 Day 1 — 자료구조 컬렉션 ArrayList 기초
 * 
 * [학습 핵심 이론: 동적 배열 자료구조 ArrayList]
 * 1. ArrayList의 특징:
 *    - 내부적으로는 일반 1차원 배열을 사용하지만, 배열이 가득 차면 자동으로 더 큰 크기의 새 배열을 생성하고 데이터를 복사하여 크기가 가상으로 무한히 늘어나는 동적 배열 컬렉션입니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: ArrayList 기본 조작 (추가, 삭제, 전체 순회) (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: ArrayList 기본 조작 (추가, 삭제, 전체 순회) (Problem 1 연계) ---");
        Lab1.run();
    }

    static class Lab1 {
        static void run() {
            // Problem 1: 이름 리스트 관리
            ArrayList<String> names = new ArrayList<>();
            names.add("홍길동");
            names.add("김철수");
            names.add("이유리");

            System.out.println("초기 리스트: " + names);

            names.remove(0); // 0번째 "홍길동" 삭제 -> 김철수, 이유리가 됨
            System.out.println("0번 인덱스 삭제 후:");
            for (String name : names) {
                System.out.println(" - " + name);
            }
        }
    }
}
