package week05.day4;

public class Answer2 {
    public static void main(String[] args) {
        System.out.println(MyMath.abs(-10));
    }
}

class MyMath {
    static int abs(int n) {
        return n < 0 ? -n : n;
    }
}
