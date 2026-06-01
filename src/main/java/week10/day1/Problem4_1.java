package week10.day1;

/**
 * [보충 문제 4_1] 다중 스레드 join() 및 sleep() 제어
 * 
 * [요구사항]
 * 1. 스레드 A(Thread A)와 스레드 B(Thread B)를 생성하여 병렬로 실행합니다.
 * 2. 스레드 A는 자신의 run() 영역에서 500ms 동안 대기 후 "Thread A 완료"를 출력합니다.
 * 3. 스레드 B는 자신의 run() 영역에서 1000ms 동안 대기 후 "Thread B 완료"를 출력합니다.
 * 4. 메인 스레드는 두 스레드가 모두 완료될 때까지 join()을 사용해 대기한 뒤,
 *    가장 마지막에 "모든 스레드 작업 종료!"를 출력해야 합니다.
 */
public class Problem4_1 {
    public static void main(String[] args)
    {
        // TODO: 스레드 A와 스레드 B를 생성 및 실행하고, join()을 통해 메인 스레드에서 대기 처리하는 코드를 작성하세요.
        System.out.println("메인작업 시작");

        Thread t1 = new ThreadTest1();
        Thread t2 = new ThreadTest2();

        t1.start();
        t2.start();

        try
        {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("모든 스레드 작업 종료!");
    }

    static class ThreadTest1 extends Thread
    {
        @Override
        public void run()
        {
            try
            {
                Thread.sleep(500);
                System.out.println("Thread A완료");
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    static class ThreadTest2 extends Thread
    {
        @Override
        public void run()
        {
            try
            {
                Thread.sleep(1000);
                System.out.println("Thread B완료");
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

}
