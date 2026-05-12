package week05.day2;

/**
 * [연습 문제 1] Week 05 Day 2
 * <p>
 * 문제: Book 클래스를 생성자를 이용해 초기화하세요.
 * 1. 필드: title, author, price
 * 2. 매개변수가 있는 생성자를 만들어 필드에 값을 대입하세요.
 * 3. main에서 제목 '자바의 정석', 저자 '남궁성', 가격 30000인 객체를 생성하고 출력하세요.
 * <p>
 * 난이도: ★☆☆☆☆
 */
public class Problem1 {
    public static void main(String[] args) {
        // TODO: Book 객체를 생성자를 통해 초기화하고 정보를 출력하세요.
        Book book = new Book("자바의 정석", "남궁성", 30000);
        book.init();

    }

    static class Book {
        String title;
        String author;
        int price;

        Book(String title, String author, int price) {
            this.title = title;
            this.author = author;
            this.price = price;
        }

        void init() {
            System.out.println("제목 : " + this.title + ",저자 : " + this.author + ", 가격 : " + this.price);
        }
    }
}
