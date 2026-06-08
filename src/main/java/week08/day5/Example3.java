package week08.day5;

import java.util.ArrayList;
import java.util.List;

/**
 * [학습 예제 3] Week 08 Day 5 — 제네릭(Generics) 심화와 와일드카드
 * 
 * [문제별 학습 목표]
 * - Lab3: ArrayList를 캡슐화한 generic Stack<T> 구현 (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        System.out.println("\n--- Lab3: ArrayList를 캡슐화한 generic Stack<T> 구현 (Problem 3 연계) ---");
        Lab3.run();
    }

    // Problem 3: 제네릭 스택 Stack<T> 정의
    static class Stack<T> {
        private final List<T> list = new ArrayList<>();

        public void push(T item) {
            list.add(item);
        }

        public T pop() {
            if (list.isEmpty()) {
                throw new IllegalStateException("스택이 비어 있어 꺼낼 수 없습니다.");
            }
            // LIFO 구조: 맨 마지막 인덱스 요소를 지우고 반환
            return list.remove(list.size() - 1);
        }

        public void print() {
            System.out.print("스택 상태: ");
            for (T item : list) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    static class Lab3 {
        static void run() {
            Stack<Integer> intStack = new Stack<>();
            intStack.push(3);
            intStack.push(4);
            intStack.push(5);
            intStack.push(6);

            intStack.print();
            
            System.out.println("pop() 된 값: " + intStack.pop()); // 6 탈출
            intStack.print();
        }
    }
}
