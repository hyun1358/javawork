package week05.day4;

/**
 * [연습 문제 2] 정적 유틸리티 클래스
 * 문제: 모든 메서드가 static인 MyMath 클래스를 만들고
 * 절대값 구하기 abs(int n) 메서드를 구현하세요.
 */
public class Problem2 {
    public static void main(String[] args) {
        System.out.println(MyMath.abs(-5));
    }

    static class MyMath {
        static int abs(int n) {
            return n < 0 ? -n : n;
        }
    }
}
