package week06.day2;

public class Answer2 {
    public static void main(String[] args) {
        Book b = new Book("자바", "홍길동");
        System.out.println(b);
    }
}

class Book {
    String title, author;

    Book(String t, String a) {
        title = t;
        author = a;
    }

    @Override
    public String toString() {
        return "제목: " + title + ", 저자: " + author;
    }
}
