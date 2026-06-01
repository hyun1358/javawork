package week10.day1;

/**
 * [연습 문제 3] 스레드 이름 확인
 * 문제: 현재 실행 중인 스레드의 이름(Thread.currentThread().getName())을
 * 출력하는 스레드 3개를 만들어 실행해보세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO

        Thread t1 = new test();
        Thread t2 = new test();
        Thread t3 = new test();

        t1.start();
        t2.start();
        t3.start();
    }

    static class test extends Thread
    {
        @Override
        public void run()
        {
            System.out.println("쓰레드 실행 이름:" + Thread.currentThread().getName());
        }
    }
}
