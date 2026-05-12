package week05.day6;

/**
 * [미니 프로젝트 가이드] Week 05 Day 6 — 도서관 관리 시스템 v1
 * <p>
 * [미션]
 * 클래스와 객체 개념을 활용하여 도서를 대출하고 반납하는
 * 간단한 도서관 관리 프로그램을 만드세요.
 * <p>
 * [필수 클래스 및 필드]
 * 1. Book 클래스
 * - 필드: private String title, private boolean isBorrowed
 * - 메서드: borrowBook()(대출처리), returnBook()(반납처리)
 * 2. Library 클래스
 * - 필드: private Book[] books (도서 목록), static int totalBooks
 * - 메서드: addBook(Book b), showBooks()
 * <p>
 * [동작 요구사항]
 * 1. 도서를 3권 정도 등록합니다. (Library의 books 배열 활용)
 * 2. 메뉴 시스템: 1.도서목록 2.대출 3.반납 4.종료
 * 3. 대출 시 이미 대출 중인 도서라면 "이미 대출 중입니다" 메시지 출력
 * <p>
 * [힌트]
 * - Book[] 배열을 순회하며 입력받은 제목과 일치하는 도서를 찾으세요.
 * - String 비교는 title.equals(input)을 사용하세요.
 */
public class MiniProjectGuide {
}
