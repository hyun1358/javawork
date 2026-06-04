package week10.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * [보충 문제 2-1] Files.newBufferedReader()를 이용한 파일 읽기
 * 문제: java.nio.file.Files 클래스의 newBufferedReader(Path) 메서드를 사용하여 
 * "mydata.txt" 파일을 읽기용 BufferedReader로 연 뒤, 파일 내용을 한 줄씩 읽어 출력하세요.
 * (힌트: Path.of("mydata.txt")와 Files.newBufferedReader()를 결합하고 try-with-resources를 사용하세요.)
 */
public class Problem2_1 {
    public static void main(String[] args)
    {
        // TODO

        try(BufferedReader br = Files.newBufferedReader(Path.of("mydata.txt"));)
        {
            String lines;
            while ((lines = br.readLine()) != null)
            {
                System.out.println(lines);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
