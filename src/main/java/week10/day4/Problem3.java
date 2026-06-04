package week10.day4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * [연습 문제 3] Append (이어쓰기)
 * 문제: "mydata.txt" 파일의 기존 내용을 지우지 않고 그 뒤에 "추가된 문구"를 덧붙여 저장하세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO (힌트: FileWriter의 생성자에 true 속성 추가)

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("mydata.txt",true)))
        {
            System.out.println("===내용 초기화 하지 않고 이어쓰기===");
            bw.newLine();
            bw.write("추가된 문구");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
