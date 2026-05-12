package week07.day3;

import java.util.Scanner;

/**
 * [연습 문제 1] IllegalArgumentException 던지기
 * 문제: 입력값이 음수이면 throw new IllegalArgumentException을 던지는 메서드를 구현하세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO

        try
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("입력: ");
            int num = sc.nextInt();
            if(num < 0)
            {
                throw new IllegalArgumentException("음수여서 오류");
            }

        }
        catch (IllegalArgumentException e)
        {
            System.out.println("오류내용: "+e.getMessage());
        }
    }
}
