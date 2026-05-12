package week07.day3;

/**
 * [연습 문제 5] 예외 감싸기 (Wrapping)
 * 문제: catch한 예외를 원인(cause)으로 삼아 새로운 RuntimeException으로 감싸서 던져보세요.
 */
public class Problem5
{
    public static void main(String[] args)
    {
        // TODO

        try
        {
            String s  = null;
            s.length();
        }
        catch (NullPointerException e)
        {
            throw new RuntimeException("문자열 길이 오류!" , e);
        }
    }


}
