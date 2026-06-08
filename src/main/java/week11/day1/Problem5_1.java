package week11.day1;

/**
 * [보충 문제 5_1] 정적 팩토리 메서드의 목적 및 설계
 *
 * 문제: 도서관의 책을 표현하는 Book 클래스를 설계하세요.
 * - Book 객체는 title(String)과 isRentable(boolean, 대여가능여부) 필드를 갖습니다.
 * - 생성자는 외부에서 호출하지 못하게 private으로 선언합니다.
 * - 목적이 명확한 아래 2개의 정적 팩토리 메서드를 제공하세요:
 *   1) public static Book createNormalBook(String title)
 *      - 일반 도서를 생성하며, 대여 가능 여부(isRentable)는 무조건 true로 고정됩니다.
 *   2) public static Book createReferenceBook(String title)
 *      - 참고용 도서를 생성하며, 대여 가능 여부(isRentable)는 무조건 false로 고정됩니다.
 * - Book 내에 정보를 확인하는 public void printInfo() 메서드도 구현하세요.
 *   (출력 형식: "Book Title: [title], Rentable: [isRentable]")
 */
public class Problem5_1 {
    public static void main(String[] args)
    {
        // TODO: Book.createNormalBook("자바의 정석") 과 Book.createReferenceBook("세계 대백과사전")을 생성하고 각각 정보를 출력하세요.
        Book b1 = Book.createNormalBook("자바의 정석");
        Book b2 = Book.createReferenceBook("세계 대백과사전");

        b1.printInfo();
        b2.printInfo();
    }

    static class Book
    {
        // TODO: 필드 선언, private 생성자 구현, 정적 팩토리 메서드 2개 구현, printInfo 메서드 구현
        String title;
        boolean isRentable;
        private Book(String title,boolean isRentable)
        {
            this.title=title;
            this.isRentable=isRentable;
        };

        public static Book createNormalBook(String title)
        {
            return new Book(title,true);
        }

        public static Book createReferenceBook(String title)
        {
            return new Book(title,false);
        }

        public void printInfo()
        {
            System.out.println("Book Title: ["+this.title+"], Rentable: ["+this.isRentable+"]");
        }
    }
}
