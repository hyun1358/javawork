package week10.day4;

import java.io.FileWriter;

public class Answer1 {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("mydata.txt")) {
            fw.write("안녕하세요!\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
