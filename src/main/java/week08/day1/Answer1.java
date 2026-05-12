package week08.day1;

import java.util.ArrayList;

public class Answer1 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("홍길동");
        names.add("이순신");
        names.add("유관순");
        names.remove("이순신");
        for (String n : names) System.out.println(n);
    }
}
