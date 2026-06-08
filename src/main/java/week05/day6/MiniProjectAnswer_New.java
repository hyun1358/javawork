package week05.day6;

import java.util.*;

/**
 * [종합 미니 프로젝트 정답 - 신규] Week 05 Day 6
 * 「 예외 처리와 컬렉션을 적용한 도서 대출 및 회원 관리 시스템 」
 * 
 * [주의] 기존 실습 파일(MiniProjectAnswer.java)과의 클래스명 충돌을 방지하기 위해 
 * 클래스명 끝에 'New' 접미사를 붙여 구분하였습니다 (BookNew, LibraryNew 등).
 */
public class MiniProjectAnswer_New {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryNew lib = new LibraryNew();

        // 초기 도서 등록
        try {
            lib.registerBook("자바의 정석");
            lib.registerBook("파이썬 입문");
            lib.registerBook("알고리즘 산책");
        } catch (Exception e) {
            System.out.println("초기 도서 등록 실패: " + e.getMessage());
        }

        boolean running = true;
        while (running) {
            System.out.println("\n=== 도서관 관리 시스템 (개선 버전) ===");
            System.out.println("1. 신규 도서 등록");
            System.out.println("2. 전체 도서 목록");
            System.out.println("3. 도서 대출 신청");
            System.out.println("4. 도서 반납 처리");
            System.out.println("5. 대출 현황 조회");
            System.out.println("6. 프로그램 종료");
            System.out.print("선택> ");

            int menu = -1;
            try {
                menu = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("[오류] 메뉴는 숫자로만 입력해 주세요.");
                continue;
            }

            switch (menu) {
                case 1:
                    System.out.print("등록할 도서 제목: ");
                    String newTitle = sc.nextLine().trim();
                    try {
                        lib.registerBook(newTitle);
                    } catch (Exception e) {
                        System.out.println("[등록 실패] " + e.getMessage());
                    }
                    break;
                case 2:
                    lib.showBooks();
                    break;
                case 3:
                    System.out.print("대출할 도서 제목: ");
                    String borrowTitle = sc.nextLine().trim();
                    System.out.print("대출인 이름: ");
                    String borrower = sc.nextLine().trim();
                    try {
                        lib.borrowBook(borrowTitle, borrower);
                    } catch (BookNotFoundExceptionNew e) {
                        System.out.println("[대출 실패 - Checked Exception] " + e.getMessage());
                    } catch (AlreadyBorrowedExceptionNew e) {
                        System.out.println("[대출 실패 - Unchecked Exception] " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("반납할 도서 제목: ");
                    String returnTitle = sc.nextLine().trim();
                    try {
                        lib.returnBook(returnTitle);
                    } catch (BookNotFoundExceptionNew e) {
                        System.out.println("[반납 실패] " + e.getMessage());
                    }
                    break;
                case 5:
                    lib.showLoanRecords();
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    running = false;
                    break;
                default:
                    System.out.println("메뉴 선택 범위는 1~6입니다.");
            }
        }
        sc.close();
    }
}

// 도서 클래스
class BookNew {
    private String title;
    private boolean isBorrowed;

    public BookNew(String title) {
        this.title = title;
        this.isBorrowed = false;
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

// Checked Exception
class BookNotFoundExceptionNew extends Exception {
    public BookNotFoundExceptionNew(String message) {
        super(message);
    }
}

// Unchecked Exception
class AlreadyBorrowedExceptionNew extends RuntimeException {
    public AlreadyBorrowedExceptionNew(String message) {
        super(message);
    }
}

// 도서관 관리 클래스
class LibraryNew {
    private List<BookNew> bookList = new ArrayList<>();
    private Set<String> bookTitles = new HashSet<>();
    private Map<String, String> loanRecords = new HashMap<>();

    public void registerBook(String title) throws Exception {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("도서 제목은 빈 값일 수 없습니다.");
        }
        
        if (bookTitles.contains(title)) {
            throw new Exception("이미 도서관에 존재하는 도서 제목입니다: " + title);
        }

        bookList.add(new BookNew(title));
        bookTitles.add(title);
        System.out.println("도서 [" + title + "]이(가) 정상 등록되었습니다.");
    }

    public void showBooks() {
        System.out.println("\n--- 도서 목록 (총 " + bookList.size() + "권) ---");
        if (bookList.isEmpty()) {
            System.out.println("보유 중인 도서가 없습니다.");
            return;
        }
        for (BookNew b : bookList) {
            System.out.printf("- %s (%s)\n", b.getTitle(), b.isBorrowed() ? "대출 중" : "대여 가능");
        }
    }

    public void borrowBook(String title, String borrower) throws BookNotFoundExceptionNew {
        BookNew targetBook = findBook(title);
        if (targetBook == null) {
            throw new BookNotFoundExceptionNew("도서관에 등록되지 않은 도서입니다: " + title);
        }

        if (targetBook.isBorrowed()) {
            throw new AlreadyBorrowedExceptionNew("해당 도서는 이미 대출 중입니다: " + title);
        }

        targetBook.setBorrowed(true);
        loanRecords.put(title, borrower);
        System.out.println("[" + title + "] 도서가 " + borrower + " 님에게 대출되었습니다.");
    }

    public void returnBook(String title) throws BookNotFoundExceptionNew {
        BookNew targetBook = findBook(title);
        if (targetBook == null) {
            throw new BookNotFoundExceptionNew("도서관에 등록되지 않은 도서입니다: " + title);
        }

        if (!targetBook.isBorrowed()) {
            System.out.println("해당 도서는 대출 중인 상태가 아닙니다.");
            return;
        }

        targetBook.setBorrowed(false);
        String borrower = loanRecords.remove(title);
        System.out.println(borrower + " 님이 대출하셨던 [" + title + "] 도서가 정상 반납되었습니다.");
    }

    public void showLoanRecords() {
        System.out.println("\n--- 도서관 대출 현황 ---");
        if (loanRecords.isEmpty()) {
            System.out.println("현재 대출된 도서가 없습니다.");
            return;
        }
        for (Map.Entry<String, String> entry : loanRecords.entrySet()) {
            System.out.printf("도서: %-15s | 대출자: %s\n", entry.getKey(), entry.getValue());
        }
    }

    private BookNew findBook(String title) {
        for (BookNew b : bookList) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }
}
