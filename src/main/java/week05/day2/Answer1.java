package week05.day2;

/*
 * [정답 + 해설 1] Week 05 Day 2
 * 문제: Book 클래스 생성자 활용
 */
public class Answer1 {
    public static void main(String[] args) {
        Book b = new Book("자바의 정석", "남궁성", 30000);
        System.out.println("제목: " + b.title);
        System.out.println("저자: " + b.author);
        System.out.println("가격: " + b.price + "원");
    }
}

class Book {
    String title;
    String author;
    int price;

    Book(String t, String a, int p) {
        title = t;
        author = a;
        price = p;
    }
}
