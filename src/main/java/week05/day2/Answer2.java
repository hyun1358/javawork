package week05.day2;

/*
 * [정답 + 해설 2] Week 05 Day 2
 * 문제: this 키워드 활용
 */
public class Answer2 {
    public static void main(String[] args) {
        // Movie 객체를 생성하며 제목과 장르를 전달하여 초기화합니다.
        Movie m = new Movie("인셉션", "SF");
        
        // 초기화된 영화 객체의 정보를 화면에 출력합니다.
        System.out.println("영화: " + m.title + " (장르: " + m.genre + ")");
    }
}

// [클래스 설명] Movie 클래스는 영화의 제목과 장르 정보를 저장합니다.
class Movie {
    String title;
    String genre;

    // [생성자 설명] this 키워드를 사용하여 매개변수와 객체의 필드를 명확하게 구분합니다.
    Movie(String title, String genre) {
        // 필드명과 매개변수명이 같을 때 this를 붙여야 필드로 인식됩니다.
        this.title = title; // this.title은 필드, title은 매개변수를 의미합니다.
        this.genre = genre; // this.genre는 필드, genre는 매개변수를 의미합니다.
    }
}
