package week07.day1;

/**
 * [연습 문제 3] NumberFormatException 잡기
 * 문제: "ABC"를 Integer.parseInt("ABC")로 숫자로 바꾸려 할 때의 예외를 처리하세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO
        String s = "ABC";
        try {
            int i = Integer.parseInt(s);
        }
        catch(NumberFormatException e)
        {
            e.printStackTrace();
        }
    }
}
