package week03.day5;

/**
 * [예습 파일] Week 03 Day 5 — Math 클래스와 난수
 */
public class Preview {
    public static void main(String[] args) {
        // 1. 랜덤 숫자 (0.0 ~ 0.999...)
        double rand = Math.random();
        System.out.println("기본 랜덤: " + rand);

        // 2. 1~10 사이 정수 만들기
        int num = (int) (Math.random() * 10) + 1;
        System.out.println("1~10 랜덤: " + num);

        // 3. 수학 함수들
        System.out.println("절대값: " + Math.abs(-5));
        System.out.println("최대값: " + Math.max(10, 20));
        System.out.println("반올림: " + Math.round(3.14));
    }
}
