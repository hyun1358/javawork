package week05.day6;

import java.util.Scanner;

/**
 * [미니 프로젝트 정답] Week 05 Day 6 — 도서관 관리 시스템 v1
 */
public class MiniProjectAnswer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library(3);

        lib.addBook(new Book("자바의 정석"));
        lib.addBook(new Book("파이썬 입문"));
        lib.addBook(new Book("알고리즘 산책"));

        boolean run = true;
        while (run) {
            System.out.println("\n1.목록 2.대출 3.반납 4.종료");
            System.out.print("선택> ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    lib.showBooks();
                    break;
                case 2:
                    System.out.print("대출할 제목: ");
                    lib.borrowBook(sc.nextLine());
                    break;
                case 3:
                    System.out.print("반납할 제목: ");
                    lib.returnBook(sc.nextLine());
                    break;
                case 4:
                    run = false;
                    break;
            }
        }
        sc.close();
    }
}

class Book {
    private String title;
    private boolean isBorrowed;

    Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}

class Library {
    private Book[] books;
    private int count = 0;

    Library(int size) {
        books = new Book[size];
    }

    public void addBook(Book b) {
        if (count < books.length)
            books[count++] = b;
    }

    public void showBooks() {
        for (int i = 0; i < count; i++) {
            System.out.println(books[i].getTitle() + " (" + (books[i].isBorrowed() ? "대출중" : "대여가능") + ")");
        }
    }

    public void borrowBook(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equals(title)) {
                if (books[i].isBorrowed())
                    System.out.println("이미 대출중입니다.");
                else {
                    books[i].setBorrowed(true);
                    System.out.println("대출 성공!");
                }
                return;
            }
        }
        System.out.println("도서를 찾을 수 없습니다.");
    }

    public void returnBook(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equals(title)) {
                books[i].setBorrowed(false);
                System.out.println("반납 성공!");
                return;
            }
        }
    }
}
