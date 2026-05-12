package week05.day6;

import java.util.Scanner;

/**
 * [미니 프로젝트] Week 05 Day 6 — 도서관 관리 시스템 v1 (실습용)
 * <p>
 * 가이드(MiniProjectGuide.java)를 참고하여
 * Book 클래스와 Library 클래스를 설계하고 기능을 완성하세요!
 */
public class MiniProject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // TODO: 도서관 객체 생성 및 메뉴 루프 구현

        System.out.println("도서관 관리 시스템을 시작합니다.");
        Library lib = new Library(3);
        lib.addBook(new Book("자바의 정석"));
        lib.addBook(new Book("파이썬 입문"));
        lib.addBook(new Book("알고리즘 산책"));

        boolean run = true;
        while (run) {
            System.out.println("메뉴 시스템: 1.도서목록 2.대출 3.반납 4.종료");
            System.out.print("선택> ");
            int select = sc.nextInt();
            sc.nextLine();

            switch (select) {
                case 1:
                    lib.showBooks();
                    break;
                case 2:
                    System.out.print("대출할 제목: ");
                    lib.borrowBook(sc.nextLine());
                    break;
                case 3:
                    System.out.print("반답할 제목: ");
                    lib.returnBook(sc.nextLine());
                    break;
                case 4:
                    System.out.println("도서대출 프로그램을 종료합니다.");
                    run = false;
                    break;
            }
            System.out.println();
        }

        sc.close();
    }

    static class Book {
        private String title;
        private boolean isBorrowed;

        boolean isBorrowed() {
            return isBorrowed;
        }

        String getTitle() {
            return title;
        }

        Book(String title) {
            this.title = title;
        }

        public void setBorrowed(boolean borrowed) {
            isBorrowed = borrowed;
        }

    }

    static class Library {
        private Book[] books;
        int totalBooks = 0;

        Library(int size) {
            books = new Book[size];
        }

        void addBook(Book b) {
            if (totalBooks < books.length) {
                books[totalBooks++] = b;
            }
        }

        void showBooks() {
            for (int i = 0; i < totalBooks; i++) {
                System.out.println(books[i].getTitle() + "(" + (books[i].isBorrowed() ? "대출중" : "대여가능") + ")");
            }
        }

        void borrowBook(String title) {
            for (int i = 0; i < totalBooks; i++) {
                if (books[i].getTitle().equals(title)) {
                    if (books[i].isBorrowed()) {
                        System.out.println("이미 대출중 입니다.");
                    } else {
                        books[i].setBorrowed(true);
                        System.out.println("대출 성공");
                    }
                }
            }
        }

        void returnBook(String title) {
            for (int i = 0; i < totalBooks; i++) {
                if (books[i].getTitle().equals(title)) {
                    if (books[i].isBorrowed) {
                        books[i].setBorrowed(false);
                        System.out.println("반납완료");
                    }
                }
            }
        }
    }
}

// TODO: Book 클래스와 Library 클래스를 정의하세요.
