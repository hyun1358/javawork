package week13.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * [13주차 미니 프로젝트] 도서 관리 시스템 (Library System)
 * 
 * 문제:
 * 1. Book 클래스를 생성하세요. (필드: id, title, author, isBorrowed)
 * 2. LibraryManager 클래스를 생성하여 도서 목록(List)을 관리하세요.
 * 3. 사용자로부터 입력을 받아 다음 기능을 수행하는 콘솔 UI를 구현하세요:
 *    - 도서 추가 (Add Book)
 *    - 전체 도서 목록 조회 (List Books)
 *    - 도서 대출 (Borrow Book)
 *    - 도서 반납 (Return Book)
 * 4. 객체 지향의 원칙에 따라 데이터, 서비스, UI 계층을 분리하여 작성하는 것을 연습합니다.
 *
 * 아래는 위 문제를 해결한 정답 예시(Answer)입니다.
 */
public class FinalProjectAnswer {
    public static void main(String[] args) {
        // [주석] UI 계층과 서비스 계층을 연결하여 프로그램을 실행합니다.
        LibraryManager manager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== 도서 관리 시스템에 오신 것을 환영합니다 ===");
        
        while (running) {
            System.out.println("\n1. 도서 추가  2. 도서 목록  3. 도서 대출  4. 도서 반납  0. 종료");
            System.out.print("선택: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("도서 제목: ");
                    String title = scanner.nextLine();
                    System.out.print("저자: ");
                    String author = scanner.nextLine();
                    manager.addBook(title, author);
                    System.out.println("도서가 추가되었습니다.");
                    break;
                case "2":
                    manager.listBooks();
                    break;
                case "3":
                    System.out.print("대출할 도서 ID: ");
                    try {
                        int borrowId = Integer.parseInt(scanner.nextLine());
                        manager.borrowBook(borrowId);
                    } catch (NumberFormatException e) {
                        System.out.println("숫자 ID를 입력해주세요.");
                    }
                    break;
                case "4":
                    System.out.print("반납할 도서 ID: ");
                    try {
                        int returnId = Integer.parseInt(scanner.nextLine());
                        manager.returnBook(returnId);
                    } catch (NumberFormatException e) {
                        System.out.println("숫자 ID를 입력해주세요.");
                    }
                    break;
                case "0":
                    running = false;
                    System.out.println("시스템을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
        scanner.close();
    }
}

class Book {
    private static int counter = 1;
    private int id;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.id = counter++;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    
    public boolean isBorrowed() { return isBorrowed; }
    public void setBorrowed(boolean borrowed) { isBorrowed = borrowed; }

    @Override
    public String toString() {
        return "[" + id + "] " + title + " (저자: " + author + ") - " + (isBorrowed ? "대출중" : "대출가능");
    }
}

class LibraryManager {
    private List<Book> books = new ArrayList<>();

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
    }

    public void listBooks() {
        System.out.println("--- 도서 목록 ---");
        if (books.isEmpty()) {
            System.out.println("등록된 도서가 없습니다.");
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void borrowBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                if (book.isBorrowed()) {
                    System.out.println("이미 대출 중인 도서입니다.");
                } else {
                    book.setBorrowed(true);
                    System.out.println("'" + book.getTitle() + "' 도서를 대출했습니다.");
                }
                return;
            }
        }
        System.out.println("해당 ID의 도서를 찾을 수 없습니다.");
    }

    public void returnBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                if (book.isBorrowed()) {
                    book.setBorrowed(false);
                    System.out.println("'" + book.getTitle() + "' 도서를 반납했습니다.");
                } else {
                    System.out.println("대출 중인 도서가 아닙니다.");
                }
                return;
            }
        }
        System.out.println("해당 ID의 도서를 찾을 수 없습니다.");
    }
}
