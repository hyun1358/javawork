package week08.day5;

public class Answer1 {
    public static void main(String[] args) {
        MyBox<Integer> b = new MyBox<>();
        b.val = 10;
        System.out.println(b.val);
    }
}

class MyBox<T> {
    T val;
}
