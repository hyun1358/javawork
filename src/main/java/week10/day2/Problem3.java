package week10.day2;

/**
 * [연습 문제 3] 은행 계좌 동기화
 * 문제: 초기 잔액이 1000원인 계좌에서 두 스레드가 동시에
 * 100원씩 10번 출금할 때 잔액이 0원이 되도록 동기화하세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO
        Bank bank = new Bank();

        Runnable task = () ->
        {
            for(int i = 0; i < 10; i++)
            {
                bank.withDraw(100);
                System.out.println("남은금액: " + bank.getBalance());
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
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }

    }

    static class Bank
    {
        private int balance = 1000;

        synchronized void withDraw(int amont)
        {
            if(balance >= amont)
            {
                try
                {
                    Thread.sleep(1000);
                    balance-=amont;
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                System.out.println("잔액부족");
            }

        }

        int getBalance() {return balance;}
    }
}
