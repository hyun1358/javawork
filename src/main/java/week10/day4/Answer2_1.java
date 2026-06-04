package week10.day4;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * [보충 문제 2-1 정답]
 */
public class Answer2_1 {
    public static void main(String[] args) {
        Path path = Path.of("mydata.txt");
        
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
