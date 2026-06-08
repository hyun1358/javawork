package week04.day1;

/**
 * [학습 예제 3] Week 04 Day 1 — 메서드 정의와 호출
 * 
 * [문제별 학습 목표]
 * - Lab3: 특정 작업을 반복 수행하는 메서드 (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        // Problem 3: drawStars() 메서드를 두 번 연달아 호출하여 별 그리기
        drawStars();
        drawStars();
    }

    static void drawStars() {
        System.out.println("*****"); // 별 5개를 화면에 출력
    }
}
