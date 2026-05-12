package week08.day1;

import java.util.ArrayList;

public class Answer3 {
    public static void main(String[] args) {
        ArrayList<StudentAns> list = new ArrayList<>();
        list.add(new StudentAns("홍길동"));
        list.add(new StudentAns("이순신"));
        for (StudentAns s : list) {
            if (s.name.equals("이순신")) System.out.println("찾았다: " + s.name);
        }
    }
}

class StudentAns {
    String name;

    StudentAns(String n) {
        name = n;
    }
}
