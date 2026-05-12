package week07.day4;

import java.util.Scanner;

/**
 * [연습 문제 1] 사용자 정의 예외 클래스 만들기
 * 문제: InsufficientBalanceException과 같은 커스텀 예외 클래스를 만들어 보세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO
        Scanner sc = new Scanner(System.in);
        try
        {
            System.out.print("돈: ");
            int money = sc.nextInt();
            sc.nextLine();
            balanceMinus(money);
        }
        catch (InsufficientBalanceException e)
        {
            System.out.println("에러원인: "+e.getMessage());
            System.out.println("에러코드: "+e.getErroCode());
        }
        finally
        {
            sc.close();
        }
    }

    public static void balanceMinus(int money)
    {
        int balance = 100;
        if(balance < money)
        {
            throw new InsufficientBalanceException("잔액부족",401);
        }
    }

    static class InsufficientBalanceException extends RuntimeException
    {
        private int erroCode;
        InsufficientBalanceException(String message, int errorCode)
        {
            super(message);
            this.erroCode = errorCode;
        }

        public int getErroCode()
        {
            return erroCode;
        }
    }
}


