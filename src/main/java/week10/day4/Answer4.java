package week10.day4;

import java.io.File;

public class Answer4 {
    public static void main(String[] args) {
        File f = new File("mydata.txt");
        if (f.exists()) {
            f.delete();
            System.out.println("삭제 완료");
        }
    }
}
