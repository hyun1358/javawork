package week07.day5;

import java.util.Scanner;

/**
 * [연습 문제 5] String.format 표 출력
 * 문제: String.format을 사용하여 3명의 이름과 점수를 깔끔하게 줄을 맞춰 출력하세요.
 */
public class Problem5 {
    public static void main(String[] args)
    {
        // TODO
        Scanner sc = new Scanner(System.in);
        String[][] strarr = new String[2][3];
        for(int i = 0; i < 3; i++)
        {
            System.out.print("이름: ");
            strarr[0][i] = sc.nextLine();
        }

        for(int i = 0; i < 3; i++)
        {
            System.out.print("점수: ");
            strarr[1][i] = sc.nextLine();
        }

        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < 3;j++)
            {
                System.out.print(String.format("%-3s\t",strarr[i][j]));
            }
            System.out.println();
        }
    }
}
