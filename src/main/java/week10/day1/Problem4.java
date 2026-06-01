package week10.day1;

/**
 * [연습 문제 4] join() 사용
 * 문제: t1 스레드가 1초간 쉬었다가 출력하도록 하고,
 * 메인 스레드에서 t1.join()을 호출해 t1이 끝날 때까지 기다렸다가 종료 메시지를 출력하세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO

        Thread t1 = new test();
        System.out.println("메인 작업 시작");
        t1.start();
        try
        {
            t1.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("쓰레드 대기 오류");
        }

        System.out.println("메인 작업 끝");

    }

    static class test extends Thread
    {
        @Override
        public void run()
        {
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                System.out.println("쓰레드 슬립 오류");
            }
            
            for(int i = 0; i < 100; i ++)
                System.out.println(i);
        }
    }
}
