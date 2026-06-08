package week05.day2;

/**
 * [학습 예제 2] Week 05 Day 2 — 생성자(Constructor) 기초와 오버로딩
 * 
 * [학습 핵심 이론: 객체의 올바른 초기화 보장]
 * 2. this 키워드:
 *    - 힙 메모리에 인스턴스화된 '자기 자신'을 가리키는 숨겨진 참조 주소 변수입니다.
 *    - 생성자나 메서드 내에서 매개변수(Parameter)와 필드(Field)의 이름이 똑같아서 발생하는 식별자 모호성(Shadowing)을 해결합니다.
 * 
 * [문제별 학습 목표]
 * - Lab2: this 키워드로 생성자 매개변수-필드 이름 충돌 해결 (Problem 2 연계)
 */
public class Example2 {
    public static void main(String[] args) {
        Movie movie = new Movie("어벤져스", "SF/액션");
        movie.showMovieInfo();
    }

    // Problem 2: Movie 클래스 정의
    static class Movie {
        String title;
        String genre;

        // this를 안 쓰면 title = title; 식은 매개변수가 매개변수 자신에 대입하는 효과만 납니다.
        Movie(String title, String genre) {
            this.title = title; // 이 인스턴스의 title 필드에 매개변수 title을 저장
            this.genre = genre; // 이 인스턴스의 genre 필드에 매개변수 genre를 저장
        }

        void showMovieInfo() {
            System.out.println("영화 제목: " + title + ", 장르: " + genre);
        }
    }
}
