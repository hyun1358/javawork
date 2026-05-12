package week05.day4;

/**
 * [연습 문제 1] 객체 카운터
 * 문제: Circle 객체가 생성될 때마다 현재까지 생성된 원의 개수를
 * static 변수를 이용해 출력하세요.
 */
public class Problem1 {
    public static void main(String[] args) {
        // new Circle(); new Circle(); -> "현재 원의 개수: 2"
        Circle c1 = new Circle();
        Circle c2 = new Circle();
        Circle c3 = new Circle();

    }

    static class Circle {
        static int count = 0;

        Circle() {
            this.count++;
            System.out.println("현재 까지 만들어진 원의 갯수 : " + this.count);
        }
    }

}
