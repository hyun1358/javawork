package week09.day4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Answer3 {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(new Student(1, "Kim"), new Student(2, "Lee"));
        Map<Integer, String> map = list.stream()
                .collect(Collectors.toMap(s -> s.id, s -> s.name));
        System.out.println(map);
    }
}

class Student {
    int id;
    String name;

    Student(int i, String n) {
        id = i;
        name = n;
    }
}
