package week09.day4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Answer3_2 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("컴퓨터공학", "김철수"),
            new Student("전자공학", "이영희"),
            new Student("컴퓨터공학", "박민수"),
            new Student("경영학", "최지영")
        );
        
        // 정답 예시: groupingBy 내부에서 mapping을 사용하여 이름만 추출
        Map<String, List<String>> majorMap = students.stream()
                .collect(Collectors.groupingBy(Student::getMajor, 
                         Collectors.mapping(Student::getName, Collectors.toList())));
                         
        System.out.println(majorMap);
    }
    static class Student {
        String major; String name;
        Student(String major, String name) { this.major = major; this.name = name; }
        String getMajor() { return major; }
        String getName() { return name; }
    }
}
