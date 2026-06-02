package week10.day2;

/**
 * [연습 문제 2] synchronized 메서드
 * 문제: Problem1의 문제를 해결하기 위해 값을 증가시키는
 * 메서드에 synchronized 키워드를 붙여 안전하게 만드세요.
 */
public class Problem2 {
    public static void main(String[] args)
    {
        // TODO
        Counter c = new Counter();
        Runnable task = () ->
        {
            for(int i = 0; i < 1000; i++)
            {
                c.increment();
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

            System.out.println("기대값: 2000, 실제값: " + c.getCount());
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    static class Counter
    {
        private int count = 0;

        synchronized void  increment() { count++;}

        int getCount() {return count;}
    }
}
