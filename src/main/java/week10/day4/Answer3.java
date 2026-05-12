package week10.day4;

import java.io.FileWriter;

public class Answer3 {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("mydata.txt", true)) { // true가 append 모드
            fw.write("추가된 문구\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
