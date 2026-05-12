package week10.day4;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Answer5 {
    public static void main(String[] args) throws Exception {
        Files.writeString(Paths.get("nio_data.txt"), "NIO 테스트");
        System.out.println(Files.readAllLines(Paths.get("nio_data.txt")));
        Files.deleteIfExists(Paths.get("nio_data.txt"));
    }
}
