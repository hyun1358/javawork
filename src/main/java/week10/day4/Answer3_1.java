package week10.day4;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * [보충 문제 3-1 정답]
 */
public class Answer3_1 {
    public static void main(String[] args) {
        Path path = Path.of("mydata.txt");
        try {
            Files.writeString(path, "NIO로 추가한 문구입니다.\n", 
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("NIO 이어쓰기 완료!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
