package week05.day2;

/*
 * [정답 + 해설 2] Week 05 Day 2
 * 문제: this 키워드 활용
 */
public class Answer2 {
    public static void main(String[] args) {
        Movie m = new Movie("인셉션", "SF");
        System.out.println("영화: " + m.title + " (장르: " + m.genre + ")");
    }
}

class Movie {
    String title;
    String genre;

    Movie(String title, String genre) {
        // 필드명과 매개변수명이 같을 때 this를 붙여야 필드로 인식됩니다.
        this.title = title;
        this.genre = genre;
    }
}
