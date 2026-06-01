package week10.day1;

/**
 * [연습 문제 1] Thread 클래스 상속
 * 문제: Thread를 상속받는 클래스를 만들어 1부터 5까지 출력하는 스레드를 실행하세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO
        System.out.println("메인 작업시작");
        Thread t1 = new countdown();
        t1.start();
        System.out.println("메인 작업끝");
    }

    static class countdown extends Thread
    {
        @Override
        public void run()
        {
            System.out.println("쓰레드 작업시작!!");
            for(int i = 1; i <= 5; i++)
            {
                System.out.print(i+" ");
            }
            System.out.println();
            System.out.println("쓰레드 작업끝!!");
        }
    }
}
