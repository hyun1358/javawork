package week10.day4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * [연습 문제 5] Files 유틸 클래스
 * 문제: Files.writeString()과 Files.readAllLines()를 사용해서 문자열을 저장하고 바로 읽어보세요.
 */
public class Problem5 {
    public static void main(String[] args)
    {
        // TODO
        try
        {
            Files.writeString(Paths.get("mydata.txt"), "안녕하세요. BufferedWirter\n사용안하고 사용중");
            System.out.println("mydata 생성및 내용 작성 완료");

            List<String> lines = Files.readAllLines(Paths.get("mydata.txt"));

            System.out.println("파일 내용 확인후 내용 출력: ");
            for(String line : lines)
            {
                System.out.println(line);
            }

            System.out.println("파일 존재 확인후 삭제");
            boolean b = Files.deleteIfExists(Paths.get("mydata.txt"));
            System.out.println("삭제여부 : " +b);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
