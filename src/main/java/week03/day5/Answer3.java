package week03.day5;

public class Answer3 {
    public static void main(String[] args) {
        int x1 = 0, y1 = 0, x2 = 3, y2 = 4;
        double dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("거리: " + dist);
    }
}
