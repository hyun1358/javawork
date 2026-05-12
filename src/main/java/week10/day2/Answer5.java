package week10.day2;

import java.util.concurrent.atomic.AtomicInteger;

public class Answer5 {
    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        Runnable r = () -> {
            for (int i = 0; i < 1000; i++) count.incrementAndGet();
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Atomic 카운트 (2000 보장): " + count.get());
    }
}
