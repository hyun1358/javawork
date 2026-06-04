package week10.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * [연습 문제 2] 한 줄씩 읽기
 * 문제: "mydata.txt" 파일의 내용을 BufferedReader의 readLine()을 이용해 화면에 출력하세요.
 */
public class Problem2 {
    public static void main(String[] args)
    {
        // TODO
        try(BufferedReader bw = new BufferedReader(new FileReader("mydata.txt")))
        {
            String line;
            System.out.println("===읽어온내용===");
            while((line = bw.readLine()) != null)
            {
                System.out.println(line);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
