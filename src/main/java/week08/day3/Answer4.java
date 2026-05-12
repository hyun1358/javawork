package week08.day3;

import java.util.*;

public class Answer4 {
    public static void main(String[] args) {
        List<Stud4> list = Arrays.asList(new Stud4("Kim", 30), new Stud4("Kim", 20));
        list.sort((o1, o2) -> {
            if (o1.name.equals(o2.name)) return o1.age - o2.age;
            return o1.name.compareTo(o2.name);
        });
        for (Stud4 s : list) System.out.println(s.name + " " + s.age);
    }
}

class Stud4 {
    String name;
    int age;

    Stud4(String n, int a) {
        name = n;
        age = a;
    }
}
