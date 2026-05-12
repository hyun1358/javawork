package week10.day1;

public class Answer1 {
    public static void main(String[] args) {
        new NumThread().start();
    }
}

class NumThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) System.out.println(i);
    }
}
