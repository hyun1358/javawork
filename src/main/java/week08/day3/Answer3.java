package week08.day3;

import java.util.*;

public class Answer3 {
    public static void main(String[] args) {
        List<Stud3> list = Arrays.asList(new Stud3("Kim"), new Stud3("Park"), new Stud3("Lee"));
        list.sort(new Comparator<Stud3>() {
            public int compare(Stud3 o1, Stud3 o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        for (Stud3 s : list) System.out.println(s.name);
    }
}

class Stud3 {
    String name;

    Stud3(String n) {
        name = n;
    }
}
