package week08.day2;

import java.util.HashMap;

public class Answer3 {
    public static void main(String[] args) {
        HashMap<Integer, StudentDto> db = new HashMap<>();
        db.put(101, new StudentDto("홍길동"));

        StudentDto s = db.get(101);
        if (s != null) System.out.println("학번 101: " + s.name);
    }
}

class StudentDto {
    String name;

    StudentDto(String n) {
        name = n;
    }
}
