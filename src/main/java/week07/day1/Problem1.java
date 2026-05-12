package week07.day1;

/**
 * [연습 문제 1] ArithmeticException 잡기
 * 문제: 0으로 나누었을 때 발생하는 예외를 try-catch로 잡아
 * "에러 발생!"을 출력하세요.
 */
public class Problem1 {
    public static void main(String[] args) {
        try
        {
            int a = 5 / 0;
        }
        catch(ArithmeticException e)
        {
            e.printStackTrace();
            System.out.println("오류 발생!");
        }
    }
}
