package week10.day5;

import java.io.FileWriter;

public class Answer5 {
    public static void main(String[] args) throws Exception {
        Stud s = new Stud("Kim", 10);
        try (FileWriter fw = new FileWriter("stud.csv")) {
            fw.write(s.name + "," + s.age + "\n");
            System.out.println("CSV 수동 저장 완료");
        }
    }
}
