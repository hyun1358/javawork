package week10.day5;

import java.io.*;

public class Answer2 {
    public static void main(String[] args) throws Exception {
        File f = new File("stud.dat");
        if (f.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
                Stud s = (Stud) in.readObject();
                System.out.println("복원 완료: " + s.name);
            }
        }
    }
}
