package week05.day2;

/**
 * [연습 문제 2] Week 05 Day 2
 * <p>
 * 문제: this 키워드를 사용하여 필드와 매개변수의 이름 충돌을 해결하세요.
 * 1. Movie 클래스에 title, genre 필드를 만듭니다.
 * 2. 생성자의 매개변수 이름을 필드 이름과 똑같게(title, genre) 만듭니다.
 * 3. this를 사용하여 필드에 값을 정확히 대입하세요.
 * <p>
 * 난이도: ★☆☆☆☆
 */
public class Problem2 {
    public static void main(String[] args) {
        // TODO: Movie 객체를 생성하고 정보를 출력하세요.
        Movie movie = new Movie("자바의 정석", "코딩");
        movie.init();

    }

    static class Movie {
        String title;
        String genre;

        Movie(String title, String genre) {
            this.title = title;
            this.genre = genre;
        }

        void init() {
            System.out.println("제목 : " + this.title + ", 장르 : " + this.genre);
        }
    }
}
