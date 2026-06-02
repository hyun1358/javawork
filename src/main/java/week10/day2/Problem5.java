package week10.day2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * [연습 문제 5] AtomicInteger 사용
 * 문제: Problem2의 코드를 synchronized 대신 AtomicInteger를
 * 사용하여 스레드 안전(Thread-safe)하게 변경하세요.
 */
public class Problem5 {
    public static void main(String[] args)
    {
        // TODO
        AtomicInteger num = new AtomicInteger(0);

        Runnable task = () ->
        {
            for(int i = 0; i < 1000; i++)
            {
                num.incrementAndGet();
            }

        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        try
        {
            t1.start();
            t2.start();

            t1.join();
            t2.join();

            System.out.println(num.get());
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
