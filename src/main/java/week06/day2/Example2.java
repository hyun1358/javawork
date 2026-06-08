package week06.day2;

/**
 * [학습 예제 2] Week 06 Day 2 — 메서드 오버라이딩(Overriding)과 Object API
 * 
 * [학습 핵심 이론: 메서드 오버라이딩과 Object 클래스]
 * 2. 최상위 조상 Object 클래스:
 *    - `toString()`: 객체의 상태를 문자열로 쉽게 모니터링하기 위해 오버라이딩합니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: toString() 재정의를 통한 인스턴스 정보 로깅 (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        Book book = new Book("자바의 정석", "홍길동");
        // System.out.println에 객체를 직접 던지면 자동으로 toString()이 호출됩니다.
        System.out.println("도서 문자열 표현: " + book);
    }

    // Problem 2: Book toString
    static class Book {
        String title;
        String author;

        Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return "제목: [" + title + "], 저자: [" + author + "]";
        }
    }
}
