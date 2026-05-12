package week10.day2;

public class Answer2 {
    static int cnt = 0;

    public static synchronized void inc() {
        cnt++;
    }

    public static void main(String[] args) throws Exception {
        Runnable r = () -> {
            for (int i = 0; i < 1000; i++) inc();
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("항상 2000 보장: " + cnt);
    }
}
