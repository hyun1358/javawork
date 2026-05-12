package week05.day5;

/**
 * [연습 문제 1] 원주율 상수
 * 문제: static final double PI = 3.14;를 선언하고
 * 이를 이용해 원의 넓이를 구하는 코드를 작성하세요.
 */
public class Problem1 {
    static final double PI = 3.14;

    public static void main(String[] args) {

        // TODO: 상수 PI를 활용해 반지름 5인 원의 넓이 출력
        int r = 5;
        System.out.println(5 * 5 * PI);
    }
}
