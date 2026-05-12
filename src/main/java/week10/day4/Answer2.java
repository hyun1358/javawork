package week10.day4;

import java.io.FileReader;
import java.io.BufferedReader;

public class Answer2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("mydata.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
