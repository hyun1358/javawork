package week07.day4;

import java.util.Scanner;

import static week07.day4.Example.login;

/**
 * [연습 문제 3] 예외에 정보 담기
 * 문제: Custom 예외에 int errorCode 필드를 추가하여
 * 에러 발생 시 함께 던져주고, catch 블록에서 이를 출력하세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO
        Scanner sc = new Scanner(System.in);
        try
        {
            System.out.print("아이디: ");
            String id = sc.nextLine();
            login(id);

        }
        catch (InvalidUserIdLengthExecption e)
        {
            System.out.println("에러메시지: " + e.getMessage());
            System.out.println("에러코드: "+ e.getErrorCode());
        }
        finally
        {
            sc.close();
        }
    }

    static void login(String id)
    {
        if(id.length() < 8)
        {
            throw new InvalidUserIdLengthExecption("사용자 아이디 길이 부족",200);
        }
    }

    static class InvalidUserIdLengthExecption extends RuntimeException
    {
        private int errorCode;

        InvalidUserIdLengthExecption(String message, int errorCode)
        {
            super(message);
            this.errorCode = errorCode;
        }

        public int getErrorCode() { return this.errorCode; }
    }
}
