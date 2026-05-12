package week09.day1;

/**
 * [예습 파일] Week 09 Day 1 — 람다식 기초
 */
public class Preview {
    public static void main(String[] args) {
        // 기존 익명 클래스 방식
        MyFunc f1 = new MyFunc() {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        };

        // 람다식 (Lambda Expression)
        MyFunc f2 = (a, b) -> a + b;

        System.out.println("기존 방식: " + f1.calc(10, 20));
        System.out.println("람다 방식: " + f2.calc(10, 20));
    }
}

@FunctionalInterface
interface MyFunc {
    int calc(int a, int b);
}
