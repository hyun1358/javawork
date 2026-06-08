package week08.day5;

/**
 * [학습 예제 1] Week 08 Day 5 — 제네릭(Generics) 심화와 와일드카드
 * 
 * [학습 핵심 이론: 컴파일 타임 타입 안전성 보장 - 제네릭]
 * 1. 제네릭 클래스 (Generic Class):
 *    - 클래스 정의 시 특정 데이터 타입을 지정하지 않고, 가상의 타입 매개변수 `<T>`를 사용해 컴파일 타임에 타입 결정을 위임하는 클래스입니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: generic 클래스 Box<T> 활용 (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        System.out.println("--- Lab1: generic 클래스 Box<T> 활용 (Problem 1 연계) ---");
        Lab1.run();
    }

    // Problem 1: 제네릭 클래스 Box<T> 정의
    static class Box<T> {
        private T content;

        Box(T content) {
            this.content = content;
        }

        public T getBox() { return content; }
        public void setBox(T content) { this.content = content; }
    }

    static class Lab1 {
        static void run() {
            Box<Integer> intBox = new Box<>(30);
            Box<String> strBox = new Box<>("숫자 30");

            System.out.println("Integer 박스 내용물: " + intBox.getBox());
            System.out.println("String 박스 내용물: " + strBox.getBox());
        }
    }
}
