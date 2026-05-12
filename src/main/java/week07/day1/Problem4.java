package week07.day1;

/**
 * [연습 문제 4] NullPointerException 잡기
 * 문제: 초기화되지 않은 문자열(null)의 메서드를 호출할 때의 예외를 처리하세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO
        try
        {
            String s = null;
            s.length();
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
        }
    }
}
