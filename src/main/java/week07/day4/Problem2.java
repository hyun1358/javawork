package week07.day4;

import java.util.Scanner;

/**
 * [연습 문제 2] RuntimeException 상속
 * 문제: throws 선언이 필요 없는 언체크드 커스텀 예외를 만들고 테스트하세요.
 */
public class Problem2 {
    public static void main(String[] args)
    {
        // TODO
        Scanner sc = new Scanner(System.in);
        try
        {
            int age = sc.nextInt();
            System.out.print("나이: ");
            sc.nextLine();
            checkAge(age);
        }
        catch(InvalidAgeException e)
        {
            System.out.println("오류메세지: " + e.getMessage());
            System.out.println("오류코드: " + e.getErrorCode());
        }
        finally
        {
            sc.close();
        }
    }

    public static void checkAge(int age)
    {
        if(age <= 0)
        {
            throw new InvalidAgeException("나이가 0보다 작거나 같습니다.",401);
        }
    }
    static class InvalidAgeException extends RuntimeException
    {
        private int errorCode;

        InvalidAgeException(String message, int errorCode)
        {
            super(message);
            this.errorCode = errorCode;
        }

        public int getErrorCode() { return errorCode;}
    }
}
