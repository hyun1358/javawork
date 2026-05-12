package week07.day3;

import java.io.IOException;

/**
 * [연습 문제 2] Checked Exception 선언
 * 문제: IOException을 throws 선언하고, 호출자(main)에서 catch하는 코드를 작성하세요.
 */
public class Problem2 {
    public static void main(String[] args)
    {
        // TODO
        try
        {
            methodA();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }

    }

    public static void methodA() throws IOException
    {
        throw new IOException("IOException발생!!");
    }

}

