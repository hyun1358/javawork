package week10.day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * [보충 문제 3-1] Files.writeString()과 StandardOpenOption을 이용한 이어쓰기
 * 문제: java.nio.file.Files.writeString()을 사용하여 "mydata.txt" 파일 끝에 
 * "NIO로 추가한 문구입니다."를 이어쓰도록 작성하세요. 
 * 단, 파일이 없으면 새로 생성하도록 옵션을 추가하세요.
 * (힌트: StandardOpenOption.CREATE, StandardOpenOption.APPEND를 매개변수로 사용하세요.)
 */
public class Problem3_1 {
    public static void main(String[] args)
    {
        // TODO
        try
        {
            Files.writeString(Path.of("mydata.txt"), "안녕하세요 지금은\n새로운 공부중입니다.",StandardOpenOption.CREATE,StandardOpenOption.APPEND);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
