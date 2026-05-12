package week03.day5;

/**
 * [학습 예제] Week 03 Day 5 — Math 활용
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("=== Lab1: 주사위 굴리기 ===");
        Lab1.run();

        System.out.println("\n=== Lab2: 수학 계산 유틸 ===");
        Lab2.run();
    }

    static class Lab1 {
        static void run() {
            int dice = (int) (Math.random() * 6) + 1;
            System.out.println("주사위 눈: " + dice);
        }
    }

    static class Lab2 {
        static void run() {
            System.out.println("2의 3제곱: " + Math.pow(2, 3));
            System.out.println("16의 제곱근: " + Math.sqrt(16));
            System.out.println("버림(3.9): " + Math.floor(3.9));
            System.out.println("올림(3.1): " + Math.ceil(3.1));
        }
    }
}
