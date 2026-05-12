package week10.day5;

import java.io.*;

public class Answer1 {
    public static void main(String[] args) throws Exception {
        Stud s = new Stud("홍길동", 20);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("stud.dat"))) {
            out.writeObject(s);
        }
    }
}

class Stud implements Serializable {
    String name;
    int age;

    Stud(String n, int a) {
        name = n;
        age = a;
    }
}
