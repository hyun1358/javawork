package week11.day1;

public class Answer5_1 {
    public static void main(String[] args) {
        // 일반 도서 생성 (대여가능여부는 자동으로 true가 셋팅됨)
        Book normalBook = Book.createNormalBook("자바의 정석");
        normalBook.printInfo();

        // 참조 도서 생성 (대여가능여부는 자동으로 false가 셋팅됨)
        Book refBook = Book.createReferenceBook("세계 대백과사전");
        refBook.printInfo();
    }

    static class Book {
        private String title;
        private boolean isRentable;

        // 1. 외부 생성을 막는 private 생성자
        private Book(String title, boolean isRentable) {
            this.title = title;
            this.isRentable = isRentable;
        }

        // 2. 일반 도서 생성 정적 팩토리 메서드
        public static Book createNormalBook(String title) {
            return new Book(title, true);
        }

        // 3. 참조 도서 생성 정적 팩토리 메서드
        public static Book createReferenceBook(String title) {
            return new Book(title, false);
        }

        // 4. 정보 출력 메서드
        public void printInfo() {
            System.out.println("Book Title: " + title + ", Rentable: " + isRentable);
        }
    }
}
