package week10.day4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * [연습 문제 1] 파일 생성과 쓰기
 * 문제: "mydata.txt" 파일을 만들고 "안녕하세요!"라는 문구를 저장하세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("mydata.txt")))
        {
            bw.write("안녕하세요!");
            System.out.println("mydata.txt 생성을 한후 내용은 안녕하세요!작성 완료");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
