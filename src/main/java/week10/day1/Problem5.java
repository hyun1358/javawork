package week10.day1;

/**
 * [연습 문제 5] 스레드 일시 정지 (sleep)
 * 문제: 반복문을 돌면서 1초(1000ms)마다 현재 카운트를 출력하는 카운트다운 스레드를 만드세요.
 */
public class Problem5 {
    public static void main(String[] args)
    {
        // TODO
        Runnable task = () ->
        {
            try
            {
                for(int i = 0; i < 10; i++)
                {
                    Thread.sleep(1000);
                    System.out.println("카운트다운: "+ (i+1));
                }

            }
            catch (InterruptedException e)
            {
                System.out.println("쓰레드 슬립 오류");
            }

        };

        Thread t1 = new Thread(task);
        t1.start();
    }
}
