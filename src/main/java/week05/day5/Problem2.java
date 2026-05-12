package week05.day5;

/**
 * [연습 문제 2] 불변 객체 만들기
 * 문제: 모든 필드가 final이고 setter가 없는
 * ImmutableBook 클래스를 작성하세요.
 */
public class Problem2 {
    public static void main(String[] args) {
        // ImmutableBook 객체 생성
        ImmutableBook book = new ImmutableBook("자바의 정석");

        // 값 읽기 예시
        System.out.println("책 제목: " + book.getName());
    }

    static class ImmutableBook {
        private final String name;

        // 생성자 이름을 클래스 이름과 일치시킴
        public ImmutableBook(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }
}
