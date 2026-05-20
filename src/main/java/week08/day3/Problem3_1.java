package week08.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * [복습 문제 3-1] 문자열 비교와 내림차순 정렬
 * 
 * 목표: 책(Book)의 제목을 기준으로 '내림차순(사전 역순, 하->가)' 정렬하세요.
 * 제약: Book 클래스를 수정하지 말고(implements 등 금지), 
 *       main 메서드 안에서 익명 클래스(Comparator)를 만드세요.
 */
public class Problem3_1 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("자바의 정석"));
        books.add(new Book("클린 코드"));
        books.add(new Book("헤드퍼스트 디자인패턴"));

        // TODO: 1. 여기에 Comparator 객체를 생성하세요. (이름 내림차순 조건)
        Comparator<Book> comparator = new Comparator<Book>()
        {
            @Override
            public int compare(Book o1, Book o2)
            {
                return o1.title.compareTo(o2.title);
            }
        };
        

        // TODO: 2. Collections.sort()를 사용하여 정렬하세요.
        Collections.sort(books, comparator);
        

        // 출력 로직 (정렬이 잘 되었는지 확인)
        for (Book b : books) {
            System.out.println(b.title);
        }
    }

    // 이 클래스는 절대 수정하지 마세요!
    static class Book {
        String title;
        Book(String title) {
            this.title = title;
        }
    }
}
