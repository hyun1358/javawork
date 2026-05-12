package week06.day2;

/**
 * [연습 문제 2] toString() 오버라이딩
 * 문제: Book 클래스의 인스턴스를 출력하면 "제목: [title], 저자: [author]"가 출력되도록 하세요.
 */
public class Problem2 {
    public static void main(String[] args)
    {
        // TODO
        Book book = new Book("자바의 정석","홍길동");
        System.out.println(book.toString());
    }

    static class Book
    {
        String title;
        String author;

        Book(String title, String author)
        {
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString()
        {
            return "제목: [" + title + "], 저자: [" + author + "]";
        }
    }
}
