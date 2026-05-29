package week05.day2;

/*
 * [정답 + 해설 1] Week 05 Day 2
 * 문제: Book 클래스 생성자 활용
 */
public class Answer1 {
    public static void main(String[] args) {
        // Book 클래스의 생성자를 호출하여 객체를 생성하면서 초기값을 바로 전달합니다.
        Book b = new Book("자바의 정석", "남궁성", 30000);
        
        // 생성된 객체의 각 필드에 저장된 값을 화면에 출력합니다.
        System.out.println("제목: " + b.title);
        System.out.println("저자: " + b.author);
        System.out.println("가격: " + b.price + "원");
    }
}

// [클래스 설명] Book 클래스는 책의 제목, 저자, 가격 정보를 담는 설계도입니다.
class Book {
    String title;
    String author;
    int price;

    // [생성자 설명] 객체 생성 시점에 제목(t), 저자(a), 가격(p)을 전달받아 필드를 초기화합니다.
    Book(String t, String a, int p) {
        title = t;
        author = a;
        price = p;
    }
}
