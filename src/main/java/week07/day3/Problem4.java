package week07.day3;

import java.io.IOException;

/**
 * [연습 문제 4] 3단계 예외 전파
 * 문제: A()가 B()를, B()가 C()를 호출할 때, C()에서 예외를 던지고 A()에서 잡게 하세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO
        A();
    }

    public static void A()
    {
        try
        {
            B();
        }
        catch (IOException e)
        {
            System.out.println("A에서 오류잡음: "+e.getMessage());
        }
    }

    public static void B() throws IOException
    {
        C();
    }

    public static void C() throws IOException
    {
        throw new IOException("오류발생!!");
    }
}
