package week05.day2;

/**
 * [학습 예제 1] Week 05 Day 2 — 생성자(Constructor) 기초와 오버로딩
 * 
 * [학습 핵심 이론: 객체의 올바른 초기화 보장]
 * 1. 생성자(Constructor)의 역할:
 *    - 객체가 `new` 연산자로 생성될 때 최초로 호출되며, 멤버 변수(필드)를 유효한 값으로 초기화하는 역할을 담당합니다.
 *    - 클래스 이름과 완전히 같아야 하고, 반환 타입(void 포함)을 적지 않습니다.
 * 
 * [문제별 학습 목표]
 * - Lab1: 생성자를 통한 Book 객체 필드 초기화 (Problem 1 연계)
 */
public class Example1 {
    public static void main(String[] args) {
        Book book = new Book("자바의 정석", "남궁성", 30000);
        book.showBookInfo();
    }

    // Problem 1: Book 클래스 정의
    static class Book {
        String title;
        String author;
        int price;

        Book(String title, String author, int price) {
            this.title = title;
            this.author = author;
            this.price = price;
        }

        void showBookInfo() {
            System.out.println("제목: " + title + ", 저자: " + author + ", 가격: " + price + "원");
        }
    }
}
