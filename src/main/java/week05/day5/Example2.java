package week05.day5;

/**
 * [학습 예제 2] Week 05 Day 5 — final 키워드와 불변 설계
 * 
 * [학습 핵심 이론: final 제약 조건을 활용한 안전성 극대화]
 * 4. 불변 객체 (Immutable Object):
 *    - 객체 생성 후 내부 상태가 절대 변하지 않는 객체입니다. 모든 필드를 `final`로 선언하고 setter를 제공하지 않아 동시성 환경에서 최고의 안전성을 가집니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: 불변 객체(Immutable Object) 클래스 설계 및 테스트 (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        ImmutableBook book = new ImmutableBook("자바의 정석", "남궁성");
        System.out.println("생성 완료된 불변 도서 제목: " + book.getTitle());
        System.out.println("생성 완료된 불변 도서 저자: " + book.getAuthor());
    }

    // Problem 2: 불변 책 클래스
    static class ImmutableBook {
        private final String title; // 불변 인스턴스 필드
        private final String author;

        public ImmutableBook(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        // setter는 작성하지 않음 -> 상태 변경 불가능(Immutable) 보장
    }
}
