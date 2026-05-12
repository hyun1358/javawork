package week09.day1;

public class Answer1 {
    public static void main(String[] args) {
        MaxFinder m = (a, b) -> a > b ? a : b;
        System.out.println("큰 수: " + m.getMax(10, 20));
    }
}

@FunctionalInterface
interface MaxFinder {
    int getMax(int a, int b);
}
