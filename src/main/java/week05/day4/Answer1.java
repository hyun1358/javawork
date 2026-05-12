package week05.day4;

public class Answer1 {
    public static void main(String[] args) {
        new Circle();
        new Circle();
        System.out.println("생성된 원의 개수: " + Circle.count);
    }
}

class Circle {
    static int count = 0;

    Circle() {
        count++;
    }
}
