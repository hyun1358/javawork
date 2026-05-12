package week10.day5;

import java.io.*;
import java.util.ArrayList;

public class Answer4 {
    public static void main(String[] args) throws Exception {
        ArrayList<Stud> list = new ArrayList<>();
        list.add(new Stud("Kim", 10));
        list.add(new Stud("Lee", 20));
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("studs.dat"))) {
            out.writeObject(list);
            System.out.println("리스트 통째로 직렬화 완료");
        }
    }
}
