package week10.day2;

public class Answer1 {
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        Runnable r = () -> {
            for (int i = 0; i < 1000; i++) cnt++;
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("2000이 아닐 수 있음: " + cnt);
    }
}
