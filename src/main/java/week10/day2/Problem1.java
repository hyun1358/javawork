package week10.day2;

/**
 * [연습 문제 1] 공유 자원 문제 확인
 * 문제: 두 스레드가 하나의 변수를 1000번씩 증가시킬 때
 * 2000이 나오지 않는 현상을 재현해보세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO
        System.out.println("메인 작업시작");
        Counter counter = new Counter();
        Runnable task = () ->
        {
            for(int i = 0; i < 1000; i++)
            {
                counter.increment();
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

            System.out.println("기대값:2000, 실제값: "+ counter.getCount());
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("메인 작업끝");
    }

    static class Counter
    {
        private int count = 0 ;

        public void increment() { count ++;}

        public int getCount() { return count;}
    }
}
