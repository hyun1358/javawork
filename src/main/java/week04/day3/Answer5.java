package week04.day3;

public class Answer5 {
    public static void main(String[] args) {
        System.out.println("원: " + area(5.0));
        System.out.println("사각형: " + area(10, 20));
        System.out.println("삼각형: " + area(10.0, 5.0));
    }

    public static double area(double r) {
        return Math.PI * r * r;
    }

    public static int area(int w, int h) {
        return w * h;
    }

    public static double area(double base, double height) {
        return base * height / 2;
    }
}
